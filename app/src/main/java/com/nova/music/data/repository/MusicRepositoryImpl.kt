package com.nova.music.data.repository

import com.nova.music.data.mapper.toSong
import com.nova.music.data.mapper.toPlainLyrics
import com.nova.music.data.remote.MusicApiService
import com.nova.music.data.remote.decipherer.SignatureDecipherer
import com.nova.music.domain.model.Song
import com.nova.music.domain.repository.MusicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val api: MusicApiService,
    private val decipherer: SignatureDecipherer
) : MusicRepository {

    override suspend fun searchSongs(query: String): Result<List<Song>> = withContext(Dispatchers.IO) {
        try {
            // Placeholder: Implementing search logic with YT Music Browse
            Result.success(emptyList()) 
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getSongDetails(videoId: String): Result<Song> = withContext(Dispatchers.IO) {
        try {
            val response = api.getPlayerResponse(videoId = videoId)
            var song = response.toSong()
            
            // Deciphering the stream URL if it's throttled or encrypted
            song.streamUrl?.let { url ->
                if (url.contains("sig=") || url.contains("signature=")) {
                    val fixedUrl = decipherer.decipherSignature(url)
                    song = song.copy(streamUrl = fixedUrl)
                }
            }
            Result.success(song)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getLyrics(videoId: String): Result<String?> = withContext(Dispatchers.IO) {
        try {
            val response = api.getLyrics(browseId = "ML${videoId}")
            Result.success(response.toPlainLyrics())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getRecommendations(videoId: String): Result<List<Song>> = withContext(Dispatchers.IO) {
        try {
            val response = api.getNextResponse(videoId = videoId)
            val songs = response.contents?.singleColumnRenderer?.tabbedRenderer?.renderer?.tabs
                ?.firstOrNull()?.tabRenderer?.content?.musicQueueRenderer?.content?.playlistPanelRenderer?.contents
                ?.mapNotNull { it.renderer?.toSong() } ?: emptyList()
            
            Result.success(songs)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

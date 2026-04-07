package com.nova.music.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NextResponseDto(
    @SerializedName("contents")          val contents: NextContentsDto?,
    @SerializedName("currentVideoEndpoint") val currentVideoEndpoint: NavigationEndpointDto?,
    @SerializedName("playerOverlays")    val playerOverlays: PlayerOverlaysDto?
)

data class NextContentsDto(
    @SerializedName("singleColumnMusicWatchNextResultsRenderer")
    val singleColumnRenderer: SingleColumnMusicWatchNextResultsRendererDto?
)

data class SingleColumnMusicWatchNextResultsRendererDto(
    @SerializedName("tabbedRenderer")
    val tabbedRenderer: WatchNextTabbedRendererContainerDto?
)

data class WatchNextTabbedRendererContainerDto(
    @SerializedName("watchNextTabbedResultsRenderer")
    val renderer: WatchNextTabbedResultsRendererDto?
)

data class WatchNextTabbedResultsRendererDto(
    @SerializedName("tabs") val tabs: List<WatchNextTabDto>?
)

data class WatchNextTabDto(
    @SerializedName("tabRenderer") val tabRenderer: WatchNextTabRendererDto?
)

data class WatchNextTabRendererDto(
    @SerializedName("title")       val title: String?,
    @SerializedName("selected")    val selected: Boolean?,
    @SerializedName("unselectable") val unselectable: Boolean?,
    @SerializedName("content")     val content: WatchNextTabContentDto?,
    @SerializedName("endpoint")    val endpoint: NavigationEndpointDto?
)

data class WatchNextTabContentDto(
    @SerializedName("musicQueueRenderer")
    val musicQueueRenderer: MusicQueueRendererDto?
)

data class MusicQueueRendererDto(
    @SerializedName("content")     val content: MusicQueueContentDto?,
    @SerializedName("subHeaderChipCloud") val subHeaderChipCloud: SubHeaderChipCloudDto?
)

data class MusicQueueContentDto(
    @SerializedName("playlistPanelRenderer")
    val playlistPanelRenderer: PlaylistPanelRendererDto?
)

data class PlaylistPanelRendererDto(
    @SerializedName("contents")    val contents: List<PlaylistPanelVideoContainerDto>?,
    @SerializedName("playlistId")  val playlistId: String?
)

data class PlaylistPanelVideoContainerDto(
    @SerializedName("playlistPanelVideoRenderer")
    val renderer: PlaylistPanelVideoRendererDto?
)

data class PlaylistPanelVideoRendererDto(
    @SerializedName("videoId")         val videoId: String?,
    @SerializedName("title")           val title: RunsContainerDto?,
    @SerializedName("thumbnail")       val thumbnail: MusicThumbnailContainerDto?,
    @SerializedName("navigationEndpoint") val navigationEndpoint: NavigationEndpointDto?
)

data class SubHeaderChipCloudDto(
    @SerializedName("chipCloudRenderer") val chipCloudRenderer: ChipCloudRendererDto?
)

data class ChipCloudRendererDto(
    @SerializedName("chips") val chips: List<ChipDto>?
)

data class ChipDto(
    @SerializedName("chipCloudChipRenderer") val renderer: ChipCloudChipRendererDto?
)

data class ChipCloudChipRendererDto(
    @SerializedName("text")              val text: RunsContainerDto?,
    @SerializedName("navigationEndpoint") val navigationEndpoint: NavigationEndpointDto?
)

data class PlayerOverlaysDto(
    @SerializedName("playerOverlayRenderer") val renderer: PlayerOverlayRendererDto?
)

data class PlayerOverlayRendererDto(
    @SerializedName("browserMediaSession") val browserMediaSession: BrowserMediaSessionDto?
)

data class BrowserMediaSessionDto(
    @SerializedName("browserMediaSessionRenderer")
    val renderer: BrowserMediaSessionRendererDto?
)

data class BrowserMediaSessionRendererDto(
    @SerializedName("album")  val album: RunsContainerDto?,
    @SerializedName("thumbnail") val thumbnail: MusicThumbnailContainerDto?
)

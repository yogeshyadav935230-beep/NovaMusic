package com.nova.music.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RunsContainerDto(
    @SerializedName("runs") val runs: List<RunDto>?
)

data class RunDto(
    @SerializedName("text") val text: String?
)

data class MusicThumbnailContainerDto(
    @SerializedName("thumbnails") val thumbnails: List<ThumbnailDto>?
)

data class ThumbnailDto(
    @SerializedName("url")    val url: String?,
    @SerializedName("width")  val width: Int?,
    @SerializedName("height") val height: Int?
)

data class NavigationEndpointDto(
    @SerializedName("browseEndpoint") val browseEndpoint: BrowseEndpointDto?,
    @SerializedName("watchEndpoint")  val watchEndpoint: WatchEndpointDto?
)

data class BrowseEndpointDto(
    @SerializedName("browseId") val browseId: String?
)

data class WatchEndpointDto(
    @SerializedName("videoId")    val videoId: String?,
    @SerializedName("playlistId") val playlistId: String?
)

data class BrowseHeaderDto(
    @SerializedName("musicHeaderRenderer") val musicHeaderRenderer: MusicHeaderRendererDto?
)

data class MusicHeaderRendererDto(
    @SerializedName("title") val title: RunsContainerDto?
)

data class MusicShelfRendererDto(
    @SerializedName("contents") val contents: List<MusicShelfContentDto>?
)

data class MusicShelfContentDto(
    @SerializedName("musicResponsiveListItemRenderer") val renderer: MusicListItemRendererDto?
)

data class MusicListItemRendererDto(
    @SerializedName("flexColumns") val flexColumns: List<MusicFlexColumnDto>?,
    @SerializedName("thumbnail")   val thumbnail: MusicThumbnailContainerDto?,
    @SerializedName("navigationEndpoint") val navigationEndpoint: NavigationEndpointDto?
)

data class MusicFlexColumnDto(
    @SerializedName("musicResponsiveListItemFlexColumnRenderer") val renderer: MusicFlexColumnRendererDto?
)

data class MusicFlexColumnRendererDto(
    @SerializedName("text") val text: RunsContainerDto?
)

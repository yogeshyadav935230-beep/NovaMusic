package com.nova.music.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MusicContextRequest(
    @SerializedName("context") val context: ContextDto
)

data class ContextDto(
    @SerializedName("client") val client: ClientDto
)

data class ClientDto(
    @SerializedName("clientName") val clientName: String = "ANDROID_MUSIC",
    @SerializedName("clientVersion") val clientVersion: String = "6.42.52",
    @SerializedName("hl") val hl: String = "en",
    @SerializedName("gl") val gl: String = "US"
)

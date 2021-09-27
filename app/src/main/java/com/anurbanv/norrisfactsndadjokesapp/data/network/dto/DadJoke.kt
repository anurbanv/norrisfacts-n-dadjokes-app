package com.anurbanv.norrisfactsndadjokesapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class DadJoke(
    @SerializedName("joke")
    override val content: String
) : TextContentObject
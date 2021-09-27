package com.anurbanv.norrisfactsndadjokesapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class NorrisFact(
    @SerializedName("value")
    override val content: String
) : TextContentObject
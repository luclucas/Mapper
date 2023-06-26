package com.lulu.mapper.model

import com.google.gson.annotations.SerializedName

data class CursoItem(
    @SerializedName("id")
    val id: String,

    @SerializedName("curso")
    val curso: String
)

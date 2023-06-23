package com.lulu.mapper.model

import com.google.gson.annotations.SerializedName

data class UnidadeFederativaItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("uf")
    val uf: String
)
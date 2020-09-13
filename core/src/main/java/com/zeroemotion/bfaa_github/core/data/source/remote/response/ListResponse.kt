package com.zeroemotion.bfaa_github.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
    @SerializedName("total_counts")
    val totalCounts: Int,
    @SerializedName("items")
    val items: List<T>
)
package com.example.retrofit2

import com.google.gson.annotations.SerializedName

/*data class ResponseListUsers(
    @SerializedName("data")
    var data: List<Data>,
    @SerializedName("page")
    var page: Int,
    @SerializedName("per_page")
    var perPage: Int,
    @SerializedName("support")
    var support: Support,
    @SerializedName("total")
    var total: Int,
    @SerializedName(
        "total_pages")
    var totalPages: Int

)*/

data class ResponseListUsers(
    var code: Int? = null,
    var expid: Int? = null,
    var date: String? = null,
    var amount: Float? = null,
    var description: String? = null,
    var type: String? = null
)
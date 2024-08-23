package com.app.mybaseapp.models.user_details


import com.google.gson.annotations.SerializedName

data class UserDetailsResponse(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("support")
    var support: Support?
)
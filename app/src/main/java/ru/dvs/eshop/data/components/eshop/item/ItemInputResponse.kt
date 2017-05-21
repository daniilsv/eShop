package ru.dvs.eshop.data.components.eshop.vendor

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemInputResponse {
    @SerializedName("response")
    @Expose
    var response: ItemResponse? = null
}
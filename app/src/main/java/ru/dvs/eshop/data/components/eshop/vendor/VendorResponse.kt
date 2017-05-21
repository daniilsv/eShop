package ru.dvs.eshop.data.components.eshop.vendor

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VendorResponse {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("items")
    @Expose
    var items: List<Vendor>? = null

    override fun toString(): String {
        return items!!.toString()
    }
}

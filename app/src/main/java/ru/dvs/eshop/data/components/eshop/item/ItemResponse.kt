package ru.dvs.eshop.data.components.eshop.vendor

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.dvs.eshop.data.components.eshop.item.Item

class ItemResponse {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    override fun toString(): String {
        return items!!.toString()
    }
}

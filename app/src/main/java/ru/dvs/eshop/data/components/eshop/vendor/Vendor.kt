package ru.dvs.eshop.data.components.eshop.vendor

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ru.dvs.eshop.data.components.Icon

class Vendor {

    @SerializedName("original_id")
    @Expose
    var originalId: Int? = null
    @SerializedName("parent_id")
    @Expose
    var parentId: Int? = null
    @SerializedName("is_enabled")
    @Expose
    var isEnabled: Boolean? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("icon")
    @Expose
    var icon: Icon? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("ordering")
    @Expose
    var ordering: Int? = null

    override fun toString(): String {
        return title!!
    }

}
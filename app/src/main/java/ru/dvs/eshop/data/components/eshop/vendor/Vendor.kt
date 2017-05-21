package ru.dvs.eshop.data.components.eshop.vendor

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ru.dvs.eshop.data.components.Icon

class Vendor {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("parent_id")
    @Expose
    var parentId: String? = null
    @SerializedName("is_enabled")
    @Expose
    var isEnabled: String? = null
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
    var ordering: String? = null
    @SerializedName("level")
    @Expose
    var level: Int? = null

    override fun toString(): String {
        return title!!
    }

}
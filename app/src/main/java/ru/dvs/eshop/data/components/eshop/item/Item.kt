package ru.dvs.eshop.data.components.eshop.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ru.dvs.eshop.data.components.Icon

class Item {
    @SerializedName("original_id")
    @Expose
    var originalId: Int? = null
    @SerializedName("is_enabled")
    @Expose
    var isEnabled: Boolean? = null
    @SerializedName("ordering")
    @Expose
    var ordering: Int? = null
    @SerializedName("category_id")
    @Expose
    var categoryId: Int? = null
    @SerializedName("art_no")
    @Expose
    var artNo: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("price")
    @Expose
    var price: Double? = null
    @SerializedName("price_old")
    @Expose
    var priceOld: Int? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null
    @SerializedName("variants")
    @Expose
    var variants: List<String>? = null
    @SerializedName("desc_short")
    @Expose
    var descShort: String? = null
    @SerializedName("desc_full")
    @Expose
    var descFull: String? = null
    @SerializedName("vendor_id")
    @Expose
    var vendorId: Int? = null
    @SerializedName("provider_id")
    @Expose
    var providerId: Int? = null
    @SerializedName("category_add_id")
    @Expose
    var categoryAddId: List<Any>? = null
    @SerializedName("img")
    @Expose
    var img: Icon? = null
    @SerializedName("images")
    @Expose
    var images: List<Icon>? = null
    @SerializedName("meta_keys")
    @Expose
    var metaKeys: String? = null
    @SerializedName("meta_desc")
    @Expose
    var metaDesc: String? = null
    @SerializedName("additional_items")
    @Expose
    var additionalItems: List<Int>? = null
    @SerializedName("add_date")
    @Expose
    var addDate: String? = null
    @SerializedName("pub_date")
    @Expose
    var pubDate: String? = null
    @SerializedName("is_hit")
    @Expose
    var isHit: Boolean? = null
    @SerializedName("is_sale")
    @Expose
    var isSale: Boolean? = null
    @SerializedName("is_best")
    @Expose
    var isBest: Boolean? = null
    @SerializedName("is_choise")
    @Expose
    var isChoise: Boolean? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("tpl")
    @Expose
    var tpl: Any? = null
    @SerializedName("chars")
    @Expose
    var chars: Any? = null

    override fun toString(): String {
        return "Title: $title Price: $price"
    }
}

package ru.dvs.eshop.data.components.eshop.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ru.dvs.eshop.data.components.Icon

class Item {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("is_enabled")
    @Expose
    var isEnabled: String? = null
    @SerializedName("ordering")
    @Expose
    var ordering: String? = null
    @SerializedName("category_id")
    @Expose
    var categoryId: String? = null
    @SerializedName("art_no")
    @Expose
    var artNo: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("price")
    @Expose
    var price: String? = null
    @SerializedName("price_old")
    @Expose
    var priceOld: Int? = null
    @SerializedName("quantity")
    @Expose
    var quantity: String? = null
    @SerializedName("variants")
    @Expose
    var variants: List<Any>? = null
    @SerializedName("desc_short")
    @Expose
    private var descShort: String? = null
    @SerializedName("desc_full")
    @Expose
    private var descFull: String? = null
    @SerializedName("vendor_id")
    @Expose
    private var vendorId: Int = 0
    @SerializedName("provider_id")
    @Expose
    private var providerId: Int = 0
    @SerializedName("category_add_id")
    @Expose
    var categoryAddId: List<Int>? = null
    @SerializedName("img")
    @Expose
    private var img: Icon? = null
    @SerializedName("images")
    @Expose
    private var images: List<Icon>? = null
    @SerializedName("meta_keys")
    @Expose
    private var metaKeys: String? = null
    @SerializedName("meta_desc")
    @Expose
    private var metaDesc: String? = null
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
    var isHit: String? = null
    @SerializedName("is_sale")
    @Expose
    var isSale: String? = null
    @SerializedName("is_best")
    @Expose
    var isBest: String? = null
    @SerializedName("is_choise")
    @Expose
    var isChoise: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("tpl")
    @Expose
    private var tpl: String? = null
    @SerializedName("url_clean")
    @Expose
    var urlClean: String? = null
    @SerializedName("category")
    @Expose
    var category: String? = null
    @SerializedName("chars")
    @Expose
    private var chars: Any? = null

    fun getChars(): Any? {
        return chars
    }

    fun setChars(chars: Any) {
        this.chars = chars
    }

    override fun toString(): String {
        return "Title: $title Price: $price"
    }
}

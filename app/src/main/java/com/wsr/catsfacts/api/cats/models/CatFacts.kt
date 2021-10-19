package com.wsr.catsfacts.api.cats.models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class CatFacts(
    val current_page: Number,
    val data: Array<CatFact>,
    val links: Array<Link>,
    val next_page_url: String,
    val path: String,
    val per_page: Number,
    val prev_page_url: String?,
    val to: Number,
    val total: Number
) {
    class ConvertFromJSON : ResponseDeserializable<CatFacts> {
        override fun deserialize(content: String): CatFacts? =
            Gson().fromJson(content, CatFacts::class.java)
    }
}
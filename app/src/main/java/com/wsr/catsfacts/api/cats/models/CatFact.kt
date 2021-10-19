package com.wsr.catsfacts.api.cats.models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


data class CatFact(
    val fact: String,
    val length: Number
) {
    class ConvertFromJSON : ResponseDeserializable<CatFact> {
        override fun deserialize(content: String): CatFact? =
            Gson().fromJson(content, CatFact::class.java)
    }
}
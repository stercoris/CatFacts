package com.wsr.catsfacts.api.cats

import com.github.kittinunf.fuel.httpGet
import com.wsr.catsfacts.api.cats.models.CatFact
import com.wsr.catsfacts.api.cats.models.CatFacts

class CatsAPI {
    companion object {
        private const val URL = "https://catfact.ninja/"

        fun getFacts(limit: Number, callback: (catFacts: CatFacts) -> Unit) {
            "${URL}facts"
                .httpGet(listOf("limit" to limit.toString()))
                .responseObject(CatFacts.ConvertFromJSON()) { _, _, result ->
                    val (catFacts) = result
                    if (catFacts === null) {
                        throw  Error("SAS")
                    }
                    callback(catFacts)
                }
        }

        fun getFact(callback: (catFacts: CatFact) -> Unit) {
            "${URL}fact"
                .httpGet()
                .responseObject(CatFact.ConvertFromJSON()) { _, _, result ->
                    val (catFacts) = result
                    if (catFacts === null) {
                        throw  Error("SAS")
                    }
                    callback(catFacts)
                }
        }
    }

}
package pl.applover.androidarchitecture.data.example.internet.params

import com.squareup.moshi.Json


/**
 * Created by Janusz Hain on 2018-01-12.
 */
data class ParamsCreateFacebookAsset(val paramsBody: ParamsBody) {

    /**
     * If you need json body in request then:
     * Generate classes using JsonToKotlinClass:
     * 1. Code
     * 2. Generate
     * 3. Convert using plugin "Json into Kotlin"
     * 4. In API in the body field of retrofit call pass [paramsBody] as argument
     */

    data class ParamsBody(
            @Json(name = "value") val value: String,
            @Json(name = "alias") val alias: String = "facebook_auth",
            @Json(name = "name") val name: String = "facebook_id"
    )


}


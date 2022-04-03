package na.severinchik.lesson6.data.entities

import com.google.gson.annotations.SerializedName


data class ResponseCatFact(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)
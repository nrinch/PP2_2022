package na.severinchik.lesson6.data.entities


import com.google.gson.annotations.SerializedName

data class ResponseGenderize(
    @SerializedName("count")
    val count: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("probability")
    val probability: Double
)
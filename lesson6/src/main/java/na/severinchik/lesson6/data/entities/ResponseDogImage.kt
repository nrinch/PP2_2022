package na.severinchik.lesson6.data.entities


import com.google.gson.annotations.SerializedName

data class ResponseDogImage(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)
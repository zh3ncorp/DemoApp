package Data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Common(
    @SerialName("custom")
    val custom: Custom,
    @SerialName("name")
    val name: String,
    @SerialName("read")
    val read: Boolean,
    @SerialName("role")
    val role: String,
    @SerialName("type")
    val type: String,
    @SerialName("unit")
    val unit: String,
    @SerialName("write")
    val write: Boolean
)
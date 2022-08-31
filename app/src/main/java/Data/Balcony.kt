package Data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Balcony(
    @SerialName("ack")
    val ack: Boolean,
    @SerialName("acl")
    val acl: AclXX,
    @SerialName("common")
    val common: CommonXX,
    @SerialName("from")
    val from: String,
    @SerialName("_id")
    val id: String,
    @SerialName("lc")
    val lc: Long,
    @SerialName("native")
    val native: NativeXX,
    @SerialName("q")
    val q: Int,
    @SerialName("ts")
    val ts: Long,
    @SerialName("type")
    val type: String,
    @SerialName("user")
    val user: String,
    @SerialName("val")
    val valX: Double
)
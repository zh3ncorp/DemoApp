package Data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AclX(
    @SerialName("object")
    val objectX: Int,
    @SerialName("owner")
    val owner: String,
    @SerialName("ownerGroup")
    val ownerGroup: String,
    @SerialName("state")
    val state: Int
)
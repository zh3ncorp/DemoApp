package Data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Influxdb0(
    @SerialName("aliasId")
    val aliasId: String,
    @SerialName("changesMinDelta")
    val changesMinDelta: Int,
    @SerialName("changesOnly")
    val changesOnly: Boolean,
    @SerialName("changesRelogInterval")
    val changesRelogInterval: Int,
    @SerialName("debounce")
    val debounce: Int,
    @SerialName("enabled")
    val enabled: Boolean,
    @SerialName("retention")
    val retention: Int,
    @SerialName("storageType")
    val storageType: String
)
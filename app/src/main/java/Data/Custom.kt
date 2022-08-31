package Data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Custom(
    @SerialName("influxdb.0")
    val influxdb0: Influxdb0
)
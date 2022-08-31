package Data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomX(
    @SerialName("influxdb.0")
    val influxdb0: Influxdb0X
)
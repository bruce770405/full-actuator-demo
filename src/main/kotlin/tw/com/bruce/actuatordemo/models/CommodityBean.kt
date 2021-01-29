package tw.com.bruce.actuatordemo.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDateTime

data class CommodityBean(
    val id: String, val name: String, val amount: BigDecimal,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    val createTime: LocalDateTime
)

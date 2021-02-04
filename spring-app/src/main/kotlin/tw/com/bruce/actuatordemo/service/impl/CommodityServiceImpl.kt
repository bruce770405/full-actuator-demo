package tw.com.bruce.actuatordemo.service.impl

import org.springframework.stereotype.Service
import tw.com.bruce.actuatordemo.models.CommodityBean
import tw.com.bruce.actuatordemo.service.CommodityService
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class CommodityServiceImpl : CommodityService {

    private val shoppingCarts: MutableMap<String, MutableList<CommodityBean>> = mutableMapOf()
    private val commodities: MutableMap<String, CommodityBean> = mutableMapOf(
        "1" to CommodityBean(
            "1", "apple",
            BigDecimal.TEN, LocalDateTime.now()
        ),
        "2" to CommodityBean(
            "2", "banana",
            BigDecimal.valueOf(20, 0), LocalDateTime.now()
        ),
        "3" to CommodityBean(
            "3", "candy",
            BigDecimal.ONE, LocalDateTime.now()
        ),
        "4" to CommodityBean(
            "4", "duck",
            BigDecimal.valueOf(100, 0), LocalDateTime.now()
        )
    )

    override fun addNewCommodityInShoppingCart(username: String, commodityId: String): CommodityBean {
        val commodity = commodities[commodityId] ?: throw Exception("no one commodity in store")
        var shoppingCart: MutableList<CommodityBean>? = shoppingCarts[username]
        if (shoppingCart.isNullOrEmpty()) shoppingCart = mutableListOf()
        shoppingCart.add(commodity)
        shoppingCarts[username] = shoppingCart
        return commodity
    }

    override fun queryAllCommodityByUser(username: String): Array<CommodityBean> {
        val shoppingCart: MutableList<CommodityBean>? = shoppingCarts[username]
        return shoppingCart?.toTypedArray() ?: arrayOf()
    }
}

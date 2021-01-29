package tw.com.bruce.actuatordemo.service.impl

import org.springframework.stereotype.Service
import tw.com.bruce.actuatordemo.models.CommodityBean
import tw.com.bruce.actuatordemo.service.CommodityService

@Service
class CommodityServiceImpl : CommodityService {

    private val shoppingCarts: MutableMap<String, MutableList<CommodityBean>> = mutableMapOf()
    private val commoditys: MutableMap<String, CommodityBean> = mutableMapOf()

    override fun addNewCommodityInShoppingCart(username: String, commodityId: String): CommodityBean {
        val commodity = commoditys[commodityId] ?: throw Exception("no one commodity in store")
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

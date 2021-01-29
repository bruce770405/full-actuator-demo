package tw.com.bruce.actuatordemo.service

import tw.com.bruce.actuatordemo.models.CommodityBean

interface CommodityService {
    fun addNewCommodityInShoppingCart(username: String, commodityId: String): CommodityBean
    fun queryAllCommodityByUser(username: String): Array<CommodityBean>
}
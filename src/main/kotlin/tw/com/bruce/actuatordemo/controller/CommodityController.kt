package tw.com.bruce.actuatordemo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import tw.com.bruce.actuatordemo.models.ActuatorResponse
import tw.com.bruce.actuatordemo.models.AddCommodityRequest
import tw.com.bruce.actuatordemo.models.CommodityBean
import tw.com.bruce.actuatordemo.service.CommodityService

@RestController
@RequestMapping("/api/v1.0/commodity")
class CommodityController(@Autowired val commodityService: CommodityService) {

    @PostMapping("/shopping")
    fun shoppingNewCommodity(@RequestBody request: AddCommodityRequest): ActuatorResponse<CommodityBean> {
        val commodityBean = this.commodityService.addNewCommodityInShoppingCart(request.username, request.commodityId)
        return ActuatorResponse("0000", commodityBean)
    }

    @GetMapping("/cart")
    fun getShoppingCartByUser(@RequestParam username: String): ActuatorResponse<Array<CommodityBean>> {
        val commodityBeanArray = this.commodityService.queryAllCommodityByUser(username)
        return ActuatorResponse("0000", commodityBeanArray)
    }
}
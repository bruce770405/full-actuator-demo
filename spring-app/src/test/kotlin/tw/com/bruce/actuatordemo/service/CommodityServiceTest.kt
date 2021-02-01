package tw.com.bruce.actuatordemo.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.jupiter.MockitoExtension
import tw.com.bruce.actuatordemo.helpers.eq
import tw.com.bruce.actuatordemo.models.CommodityBean
import java.math.BigDecimal
import java.time.LocalDateTime


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
@ExtendWith(MockitoExtension::class)
internal class CommodityServiceTest {

    @Mock
    private lateinit var service: CommodityService

    @Test
    @DisplayName("add new commodity in shopping cart is success")
    fun testAddNewCommodityInShoppingCart() {
        val commodityId = "mock-test"
        val username = "bruce"
        val commodityBean = CommodityBean(commodityId, "commodity", BigDecimal("500"), LocalDateTime.now())
        doReturn(commodityBean).`when`(service).addNewCommodityInShoppingCart(eq(username), eq(commodityId))
        val commodity = service.addNewCommodityInShoppingCart(username, commodityId)
        assertThat(commodity).isNotNull.isEqualTo(commodityBean)
    }

    @Test
    @DisplayName("query commodities in shopping cart is success")
    fun testQueryAllCommodityByUser() {
        val commodityId = "mock-test"
        val username = "bruce"
        val commodityBeanArray =
            arrayOf(CommodityBean(commodityId, "commodity", BigDecimal("500"), LocalDateTime.now()))
        doReturn(commodityBeanArray).`when`(service).queryAllCommodityByUser(eq(username))
        val commoditys = service.queryAllCommodityByUser(username)
        assertThat(commoditys).isNotNull.hasSize(1).isEqualTo(commodityBeanArray)
    }

}



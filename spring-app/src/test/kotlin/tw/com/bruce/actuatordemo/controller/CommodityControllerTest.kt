package tw.com.bruce.actuatordemo.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import tw.com.bruce.actuatordemo.helpers.eq
import tw.com.bruce.actuatordemo.models.ActuatorResponse
import tw.com.bruce.actuatordemo.models.AddCommodityRequest
import tw.com.bruce.actuatordemo.models.CommodityBean
import tw.com.bruce.actuatordemo.service.CommodityService
import java.math.BigDecimal
import java.time.LocalDateTime

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class CommodityControllerTest(
    @Autowired
    private val mockMvc: MockMvc
) {

    @MockBean
    private lateinit var service: CommodityService

    val mapper = ObjectMapper()

    @Test
    @DisplayName("add new commodity in shopping cart is success")
    fun testAddNewCommodityInShoppingCart() {
        val commodityId = "mock-test"
        val username = "bruce"
        val commodityBean = CommodityBean(commodityId, "commodity", BigDecimal("500"), LocalDateTime.now())
        Mockito.doReturn(commodityBean).`when`(service).addNewCommodityInShoppingCart(eq(username), eq(commodityId))

        // expect request && response data
        val requestData = mapper.writeValueAsString(AddCommodityRequest(username, commodityId))
        val responseData = mapper.writeValueAsString(ActuatorResponse("0000", commodityBean))

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/api/v1.0/commodity/shopping")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestData)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))

    }
}
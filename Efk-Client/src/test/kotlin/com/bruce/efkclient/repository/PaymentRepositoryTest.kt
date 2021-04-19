package com.bruce.efkclient.repository

import assertk.assertThat
import com.github.dockerjava.api.DockerClient
import org.arquillian.cube.HostIp
import org.arquillian.cube.HostPort
import org.jboss.arquillian.junit5.ArquillianExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ArquillianExtension::class)
class PaymentRepositoryTest {

    private lateinit var docker: DockerClient

    @HostIp
    private lateinit var dockerHost: String

    @HostPort(containerName = "efk-client", value = 8080)
    private var servicePort: Int = 0

    @Test
    fun should_expose_correct_port() {
        assertThat(docker)
            .container("efk-client")
            .hasExposedPorts("8080/tcp");
    }

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
}
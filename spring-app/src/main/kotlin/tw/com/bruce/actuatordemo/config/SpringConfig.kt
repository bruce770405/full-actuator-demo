package tw.com.bruce.actuatordemo.config

import org.springframework.context.annotation.Configuration
import io.micrometer.core.instrument.MeterRegistry

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.context.annotation.Bean


@Configuration
class SpringConfig {

    @Bean
    fun metricsCommonTags(): MeterRegistryCustomizer<MeterRegistry>? {
        return MeterRegistryCustomizer { registry: MeterRegistry ->
            registry.config().commonTags("application", "spring-app")
        }
    }
}
package tw.com.bruce.actuatordemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ActuatorDemoApplication

fun main(args: Array<String>) {
    runApplication<ActuatorDemoApplication>(*args)
}

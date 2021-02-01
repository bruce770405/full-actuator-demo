package tw.com.bruce.actuatordemo.global

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import tw.com.bruce.actuatordemo.models.ActuatorResponse
import java.lang.Exception
import java.lang.RuntimeException

@RestControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    /**
     * Handle the artifact CRUD related exceptions.
     *
     * @param ex autowired exceptions.
     * @return the Http status and the json string represents the exception.
     */
    @ExceptionHandler(RuntimeException::class)
    fun handle(ex: Exception): ResponseEntity<ActuatorResponse<Any?>> {
        logger.error("global exception error", ex)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ActuatorResponse("9999", null))
    }
}
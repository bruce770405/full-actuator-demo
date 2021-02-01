package tw.com.bruce.actuatordemo.models

data class ActuatorResponse<T>(val code: String, val data: T)

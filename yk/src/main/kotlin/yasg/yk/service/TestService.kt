package yasg.yk.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TestService {

    @Value("\${a}")
    lateinit var a: String

    @Value("\${b}")
    lateinit var b: String

    fun calQuadraticEquation(x: Int) = a.toInt() * x * x + b.toInt() * x
}
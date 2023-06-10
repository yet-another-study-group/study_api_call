package yasg.yk.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yasg.yk.service.TestService

@RestController
@RequestMapping("/api")
class TestController(
    private val testService: TestService
) {

    @GetMapping( "/cal/{x}")
    fun calculateQuadraticEquation(@PathVariable x: Int) = testService.calQuadraticEquation(x)

}
# ✏️ OpenFeign 적용해보기
## OpenFeign이란?
OpenFeign은 Netflix에 의해 처음 만들어진 Declarative(선언적인) HTTP Client 도구로써, 외부 API 호출을 쉽게할 수 있도록 도와준다. 

OpenFeignd의 변화

`Netflix OSS → Spring Cloud Netflix → Open Feign → Spring Cloud Open Feign`

장점

- 인터페이스와 어노테이션 기반으로 작성할 코드가 줄어든다.
- 익숙한 Spring MVC 어노테이션으로 개발이 가능하다.
- 다른 Spring Cloud 기술들(Eureka, Circuit Breaker, LoadBalancer) 과의 통합이 쉽다.

단점 & 한계

- 기본 Http Client가 Http2를 지원하지 않는다(Http Client에 대한 추가 설정이 필요함).
- 공식적으로 Reactive 모델을 지원하지 않는다(비공식 오픈소스 라이브러리로 사용 가능함).
- 경우에 따라 애플리케이션이 실행될 대 초기화 에러가 발생할 수 있다(Object Provider로 대응이 필요함).
- 테스트 도구를 제공하지 않는다(별도의 설정 파일을 작성하여 대응이 필요함).

---

## OpenFeign 적용

1. **의존성 추가**

```java
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	implementation group: 'org.springframework.cloud', name: 'spring-cloud-starter-openfeign', version: '3.1.3'
	implementation 'org.apache.commons:commons-math3:3.6.1'
}
```

여기서 주의점은 Spring Cloud는 Spring Boot 버전과 호환되는 버전을 사용해야 한다.

[**Spring Cloud 문서**](https://spring.io/projects/spring-cloud)를 참고하기 바란다.

2. **OpenFeign 활성화**

OpenFeign을 활성화하려면 `@EnableFeignClients` 어노테이션을 붙여주면 된다.

기본적으로는 main 클래스에 붙여준다.

```java
@SpringBootApplication
@EnableFeignClients
public class HyyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyyApplication.class, args);
	}
}
```

여기서 궁금한게 있다 왜 main 클래스에 적용을 할까?

@EnableFeignClients 어노테이션은 하위 클래스를 탐색하면서 @FeignClient를 찾아 구현체를 생성하는 역할을 한다.

위 글을 보면 알겠지만 main 클래스에 적용하면 하위 클래스를 다 탐색하기 때문에 기본적으로 main 클래스에 적용하는 것 같다.

하지만 **main 클래스에 @EnableFeignClients 어노테이션을 붙여주는 것은 SpringBoot가 제공하는 테스트에 영향을 줄 수 있다.** 그러므로 별도의 **Config** 파일로 만들어주는 것이 좋다.

별도의 파일로 설정할 경우 feign 인터페이스들의 위치를 반드시 지정해주어야 한다. componentScan 처럼 baseBackes로 지정해주거나, clients로 직접 클래스들을 지정해줘도 된다.

일반적으로 아래와 같이 패키지로 지정한다.

```java
@Configuration
@EnableFeignClients("com.study.hyy")
class OpenFeignConfig {

}
```

3. **Feign Client 구현**
- 적용할 외부 API 코드

```kotlin
@RestController
@RequestMapping("/api")
class TestController(
    private val testService: TestService
) {

    @GetMapping( "/cal/{x}")
    fun calculateQuadraticEquation(@PathVariable x: Int) = testService.calQuadraticEquation(x)

}
```

API 호출을 수행할 클라이언트는 인터페이스에 `@FeignClient` 어노테이션을 설정한다. **name에는 클라이언트의 이름을 설정**하고, **url에는 호출할 api의 주소를 설정**한다.

```java
@FeignClient(name = "YkFeignClient", url="http://localhost:8081")
public interface YkFeignClient {
    @GetMapping(value = "/api/cal/{x}")
    int getValue(@PathVariable("x") int x);
}
```

4. **FeinÇlient config 정보 설정**

Config 클래슬르 생성하고 필요한 각 설정 정보를 아래와 같이 셋팅 가능하다.

✅ Config 클래스를 따로 생성하지 않아도 아래 Bean들은 기본적으로 제공된다.

```java
Spring Cloud OpenFeign provides the following beans by default for feign (BeanType beanName: ClassName):
Decoder feignDecoder: ResponseEntityDecoder (which wraps a SpringDecoder)
Encoder feignEncoder: SpringEncoder
Logger feignLogger: Slf4jLogger
MicrometerCapability micrometerCapability: If feign-micrometer is on the classpath and MeterRegistry is available
CachingCapability cachingCapability: If @EnableCaching annotation is used. Can be disabled via feign.cache.enabled.
Contract feignContract: SpringMvcContract
Feign.Builder feignBuilder: FeignCircuitBreaker.Builder
Client feignClient: If Spring Cloud LoadBalancer is on the classpath, FeignBlockingLoadBalancerClient is used. If none of them is on the classpath, the default feign client is used.
```

❎ 아래 bean들은 기본으로 제공되지 않고 필요시 config 클래스에 생성해줘야 한다.
```java
Logger.Level
Retryer
ErrorDecoder
Request.Options
Collection<RequestInterceptor>
SetterFactory
QueryMapEncoder
Capability (MicrometerCapability and CachingCapability are provided by default)
```

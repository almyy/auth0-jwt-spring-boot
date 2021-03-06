package com.github.jwt.auth0

import com.github.jwt.auth0.web.JwtHeader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "jwt-test-mode=true")
class TestApplicationSpec extends Specification {

    @Autowired
    WebApplicationContext context

    @Autowired
    private JwtHeader jwtHeader

    def "Initialize Auth0 JWT Spring beans"() {
        when:
        def claims = jwtHeader.get()

        then:
        claims.size() > 0
    }
}

package bluebird.emm.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
    Web Security 구성
 */
@EnableWebSecurity
public class ResourceServerConfig {

    /*
        article resource 에 대한 모든 요청은 승인이 요구되어야 하고
        scope 로 적절한 권한 (articles.read)이 있어야 접근이 가능하도록 설정
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.mvcMatcher("/articles/**")
                .authorizeRequests()
                .mvcMatchers("/articles/**")
                .access("hasAuthority('SCOPE_articles.read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}

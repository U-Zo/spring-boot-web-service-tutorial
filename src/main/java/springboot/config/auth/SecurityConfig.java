package springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springboot.domain.user.Role;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // h2-console 화면 사용하기 위해 disable
                .headers().frameOptions().disable()
                .and()
                // url 별 권한 관리 설정 시작
                // antMatchers를 사용하기 위함
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                // 로그아웃 기능의 시작점
                // 로그아웃 성공 시 / 주소로 이동
                .logout().logoutSuccessUrl("/")
                .and()
                // oauth2Login: OAuth2 로그인 기능의 시작점
                // userInfoEndpoint: 로그인 성공 이후 사용자 정보를 가져올 때 설정
                // userService: 로그인 성공 후 진행할 서비스 구현체 등록
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}

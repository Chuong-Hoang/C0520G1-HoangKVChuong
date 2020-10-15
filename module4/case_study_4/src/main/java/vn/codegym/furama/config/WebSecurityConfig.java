package vn.codegym.furama.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.codegym.furama.service.security_service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/home").permitAll()
                .and()
                .authorizeRequests().antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll();
//                .authorizeRequests()
//                    .antMatchers("/register").permitAll()
//                    .antMatchers("/").hasRole("MEMBER")
//                    .antMatchers("/admin").hasRole("ADMIN")
//                    .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .defaultSuccessUrl("/")
//                    .failureUrl("/login?error")
//                    .and()
//                .exceptionHandling()
//                    .accessDeniedPage("/login/403");
    }
}

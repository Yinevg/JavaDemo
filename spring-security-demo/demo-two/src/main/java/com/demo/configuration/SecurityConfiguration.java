package com.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Created by Yinevg on 2020/5/13
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("deprecation")
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()  // 使用内存中的 InMemoryUserDetailsManager
            .passwordEncoder(NoOpPasswordEncoder.getInstance()) // 不使用 PasswordEncoder 密码编码器
            .withUser("admin").password("admin").roles("ADMIN") // 配置 admin 用户
            .and().withUser("normal").password("normal").roles("NORMAL"); // 配置 normal 用户
    }
}

package com.teste.kt.testekt.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.support.beans
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager


import org.springframework.security.core.userdetails.UserDetails




@EnableWebSecurity
class SecurityConfiguration: WebSecurityConfigurerAdapter() {

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {

        auth.inMemoryAuthentication()
            .withUser("root")
            .password(encoder().encode("root"))
            .roles("USER", "ADMIN")
            .and()


        }
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/message").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/message/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/message/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/message/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/message/**").hasAnyRole("ADMIN", "USER")
            .and()
            .csrf().disable()
            .formLogin().disable()
    }


    @Bean
    fun inMemoryUserDetailsManager(): InMemoryUserDetailsManager? {
        val admin: UserDetails = User.withDefaultPasswordEncoder()
            .username("root").password("root").roles("USER", "ADMIN").build()
        val inMemoryUserDetailsManager = InMemoryUserDetailsManager()
        inMemoryUserDetailsManager.createUser(admin)
        return inMemoryUserDetailsManager
    }

}
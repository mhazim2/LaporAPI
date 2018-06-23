package com.example.laporapi.authentication;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Authentication : User --> Roles

//    protected BasicDataSource dataSource = new BasicDataSource();
//    dataSource
//    dataSource.setDriverClassName(env.getProperty("mysql.driver"));
//    dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
//    dataSource.setUsername(env.getProperty("mysql.username"));
//    dataSource.setPassword(env.getProperty("mysql.password"));

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled"
                        + " from users where username=?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from authorities where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    // Authorization : Role -> Access
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers("/laporan/**", "/uploadFile/**", "/downloadFile/**")
                .hasRole("ADMIN").antMatchers("/**").hasRole("USER").and()
                .csrf().disable().headers().frameOptions().disable();
    }

}
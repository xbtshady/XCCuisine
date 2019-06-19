//package com.XCCuisine.security;
//
//import com.XCCuisine.dao.UserMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import javax.annotation.Resource;
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/index").permitAll()//访问index.html不要权限验证
////                .anyRequest().authenticated()//其他所有路径都需要权限校验
////                .and()
////                .csrf().disable()//默认开启，这里先显式关闭
////                .formLogin()  //内部注册 UsernamePasswordAuthenticationFilter
////                .loginPage("/login") //表单登录页面地址
////                .loginProcessingUrl("/login")//form表单POST请求url提交地址，默认为/login
////                .permitAll();//允许所有用户都有权限访问登录页面
//
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
////    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Resource
//            UserMapper userMapper;
//
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                PasswordEncoder encoder =
//                        PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//                UserDetails user = User.withUsername(username)
//                        .password(encoder.encode(userMapper.selectByUserName(username).getPassword()))
//                        .roles("USER").build();
//
//                return user;
//            }
//        };
//    }
//}

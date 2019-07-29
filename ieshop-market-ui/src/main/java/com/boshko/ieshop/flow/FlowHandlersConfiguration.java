package com.boshko.ieshop.flow;

import com.boshko.ieshop.flow.register.UserRegisterHandler;
import com.boshko.ieshop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(UserService userService){
        return new UserRegisterHandler(userService);
    }
}

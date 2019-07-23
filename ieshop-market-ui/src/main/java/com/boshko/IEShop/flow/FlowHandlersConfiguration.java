package com.boshko.IEShop.flow;

import com.boshko.IEShop.flow.register.UserRegisterHandler;
import com.boshko.IEShop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(UserService userService){
        return new UserRegisterHandler(userService);
    }
}

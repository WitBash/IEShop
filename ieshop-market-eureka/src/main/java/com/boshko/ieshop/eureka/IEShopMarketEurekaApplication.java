package com.boshko.ieshop.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class IEShopMarketEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IEShopMarketEurekaApplication.class, args);
    }
}

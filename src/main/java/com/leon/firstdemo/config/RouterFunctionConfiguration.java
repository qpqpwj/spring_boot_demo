package com.leon.firstdemo.config;

import com.leon.firstdemo.domain.User;
import com.leon.firstdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * ${DESCRIPTION}
 *
 * @author jian.wang03@owitho.com
 * @create 2018-04-02 下午5:14
 * ${DESCRIPTION}
 **/
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                serverRequest -> {
                    Collection<User> users = userRepository.findAll();
                    Mono<ServerResponse> response = null;
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
        });
    }
}

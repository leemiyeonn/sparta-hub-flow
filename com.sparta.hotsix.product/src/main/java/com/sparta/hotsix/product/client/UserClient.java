package com.sparta.hotsix.product.client;

import com.sparta.hotsix.product.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/api/v1/users/{userId}")
    UserDto.Response getUserById(@PathVariable("userId") String userId);
}
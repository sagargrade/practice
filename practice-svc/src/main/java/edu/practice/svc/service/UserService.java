package edu.practice.svc.service;

import edu.practice.svc.bo.UserBO;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;
    private final String userApiUrl = "https://jsonplaceholder.typicode.com/users";

    @Async
    public CompletableFuture<UserBO[]> getUsers() {
        return CompletableFuture.completedFuture(restTemplate.getForObject(userApiUrl, UserBO[].class));
    }
}

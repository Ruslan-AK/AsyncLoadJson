package com.example.asyncmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class GitHubLookupService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;
    private long millis;

    public GitHubLookupService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Async
    public CompletableFuture<User> findUser(String userStr) throws InterruptedException {
        logger.info("Looking up " + userStr);
        String userUrl = String.format("https://api.github.com/users/%s", userStr);
        User user = restTemplate.getForObject(userUrl, User.class);
        if (user.getReposUrl() != null) {
            List<Repos> repos = Arrays.asList(restTemplate.getForEntity(user.getReposUrl(), Repos[].class).getBody());
            user.setRepos(repos);
        }
        millis = 1000L;
        Thread.sleep(millis);
        return CompletableFuture.completedFuture(user);
    }
}

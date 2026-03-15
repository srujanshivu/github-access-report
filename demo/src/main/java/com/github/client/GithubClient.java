package com.github.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

@Component
public class GithubClient {

    private RestTemplate restTemplate = new RestTemplate();

    private String token = "YOUR_GITHUB_TOKEN"; // Replace with your GitHub token

    public List<Map<String, Object>> getRepositories() {

        String url = "https://api.github.com/orgs/github/repos";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                List.class
        );

        return response.getBody();
    }

    public List<Map<String, Object>> getCollaborators(String repoName) {

         String url = "https://api.github.com/repos/github/" + repoName + "/contributors";

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + token);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<List> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            List.class
    );

    return response.getBody();
}
}
package com.github.service;

import com.github.client.GithubClient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GithubService {

    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public Map<String, List<String>> getAccessReport() {

        Map<String, List<String>> userAccessMap = new HashMap<>();

        // Get repositories
        List<Map<String, Object>> repos = githubClient.getRepositories();

        for (Map<String, Object> repo : repos) {

            String repoName = repo.get("name").toString();

            // Get collaborators for each repo
            List<Map<String, Object>> users = githubClient.getCollaborators(repoName);

            if (users == null) continue;

            for (Map<String, Object> user : users) {

                String username = user.get("login").toString();

                userAccessMap
                        .computeIfAbsent(username, k -> new ArrayList<>())
                        .add(repoName);
            }
        }

        return userAccessMap;
    }
}
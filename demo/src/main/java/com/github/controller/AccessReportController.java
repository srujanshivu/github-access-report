package com.github.controller;

import com.github.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AccessReportController {

    private final GithubService githubService;

    public AccessReportController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/access-report")
    public Map<String, List<String>> getReport() {
        return githubService.getAccessReport();
    }
}



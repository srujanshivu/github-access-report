# GitHub Access Report Service

## Project Overview

This project is a Spring Boot REST API that generates an access report for repositories in a GitHub organization.

The application fetches repositories from GitHub and retrieves contributors for each repository.
It then creates a mapping of users to the repositories they contribute to.

The result is returned through a REST API endpoint.

---

# Technologies Used

* Java
* Spring Boot
* Maven
* GitHub REST API

---

# How to Run the Project

1. Clone the repository

git clone https://github.com/srujanshivu/github-access-report.git

2. Navigate to the project directory

cd github-access-report/demo

3. Run the application

mvn spring-boot:run

4. The application will start on

http://localhost:8080

---

# Authentication Configuration

The GitHub API requires authentication for higher request limits.

This project uses a **GitHub Personal Access Token (PAT)**.

Steps:

1. Generate a token from GitHub settings
   https://github.com/settings/tokens

2. Add the token in the `GithubClient` class when making API requests.

The token is sent using the HTTP Authorization header.

For security reasons, the token is not stored in the repository.

---

# API Endpoint

After running the application, call the following endpoint:

http://localhost:8080/access-report

This endpoint returns a JSON response mapping GitHub users to the repositories they contribute to.

Example response:

{
"user1": ["repo1", "repo2"],
"user2": ["repo3"]
}

---

# Assumptions and Design Decisions

1. The GitHub organization used for demonstration is **github**.
2. The `/contributors` endpoint is used instead of `/collaborators` because collaborators require special permissions.
3. The application follows a layered architecture:

Controller → Service → Client → GitHub API

4. The service aggregates contributors across repositories to generate a user-to-repository mapping.

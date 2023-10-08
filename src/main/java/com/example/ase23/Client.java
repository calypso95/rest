package com.example.ase23;

import com.example.ase23.entity.Planet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Objects;

public class Client {

    WebClient client = WebClient.create("localhost:8080");

    public Planet getPlanets() {
        Mono<Planet> tokenMono = client.get().uri("/planets")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Planet.class);
        return tokenMono.share().block();
    }

    /*public String getProblem(String stage, String testcase, Token token) {
        Mono<Problem> problemMono = client.get().uri("/stage/" + stage + "/testcase/" + testcase + "?token=" + token.getToken())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Problem.class);
        Problem problem = problemMono.share().block();
        //System.out.println(problem.getEquation());
        //System.out.println(problem.getLength());
        //System.out.println(Arrays.toString(problem.getPaths()));
        System.out.println(Arrays.toString(problem.getPlanets()));
        System.out.println(Arrays.toString(problem.getQuestions()));
        String solution = submitSolution(stage, testcase, token, problem);
        return solution.split("//")[1];
    }

    public String submitSolution(String stage, String testcase, Token token, Problem problem) {
        Solution solution = new Solution();
        if (Objects.equals(stage, "1")) {
            solution.solve(problem);
            System.out.println(solution.getSolutions());
        } else if (Objects.equals(stage, "2")) {
            //solution.solve2(problem);
            System.out.println(solution.getSolutions());
        }
        String solutionMono = client.post().uri("/stage/" + stage + "/testcase/" + testcase + "?token=" + token.getToken())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(solution.getSolutions()), Solution.class)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();
        System.out.println(solutionMono);
        return solutionMono;
    }*/

}

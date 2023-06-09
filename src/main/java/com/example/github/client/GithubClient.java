package com.example.github.client;

import com.example.github.exception.UserNotFoundException;
import com.example.github.model.Branch;
import com.example.github.model.GithubOwner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GithubClient {
    private static final String GITHUB_URL = "https://api.github.com";
    private final RestTemplate restTemplate;

    public List<GithubOwner> get(String nameOwner) throws UserNotFoundException {
        try{
            GithubOwner[] owners = restTemplate.getForObject(
                    GITHUB_URL + "/users/" + nameOwner + "/repos",
                    GithubOwner[].class
            );
            return Arrays.asList(owners);
        }catch(HttpClientErrorException exception){
            if(exception.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                throw new UserNotFoundException(nameOwner);
            }
            throw exception;
        }
    }
    public List<Branch> getBranches(String nameOwner, String nameRepository) {
        Branch[] branches = restTemplate.getForObject(
                GITHUB_URL + "/repos/" + nameOwner +"/"+nameRepository+ "/branches",
                Branch[].class
        );
        return Arrays.asList(branches);
    }

}

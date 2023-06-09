package com.example.github;

import com.example.github.exception.NotAcceptableException;
import com.example.github.exception.UserNotFoundException;
import com.example.github.model.GithubOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github")
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/{nameOwner}")
    List<GithubOwnerDto> get(@PathVariable String nameOwner,@RequestHeader(value = "Accept", required = false) String acceptHeader) throws UserNotFoundException, NotAcceptableException, HttpMediaTypeNotAcceptableException {
        if(acceptHeader.equals(MediaType.APPLICATION_XML_VALUE)){
            throw new HttpMediaTypeNotAcceptableException(acceptHeader);
        }else {
            return githubService.get(nameOwner);
        }
    }
}

package com.example.github;


import com.example.github.model.GithubOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github")
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/{nameOwner}")
    List<GithubOwnerDto> get(@PathVariable String nameOwner){
        return githubService.get(nameOwner);

    }
}

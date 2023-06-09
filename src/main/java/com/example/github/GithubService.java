package com.example.github;

import com.example.github.client.GithubClient;
import com.example.github.exception.UserNotFoundException;
import com.example.github.model.Branch;
import com.example.github.model.GithubOwner;
import com.example.github.model.GithubOwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GithubService {
    private final GithubClient githubClient;
    private final ModelMapper modelMapper;

    public List<GithubOwnerDto> get(String nameOwner) throws UserNotFoundException {
        List<GithubOwner> githubOwners = githubClient.get(nameOwner)
                .stream()
                .filter(githubOwner -> !githubOwner.getFork())
                .collect(Collectors.toList());
        githubOwners.forEach(owner->addBranches(owner,nameOwner));
        githubOwners.forEach(owner-> owner.setNameOwner(nameOwner));
        return convertToDto(githubOwners);
    }
    List<GithubOwnerDto> convertToDto(List<GithubOwner> githubOwners){
        return githubOwners.stream()
                .map(owners->modelMapper.map(owners,GithubOwnerDto.class))
                .toList();
    }
    private void addBranches(GithubOwner githubOwner,String nameOwner){
        List<Branch> branches = githubClient.getBranches(nameOwner, githubOwner.getName());
        githubOwner.setBranches(branches);
    }
}

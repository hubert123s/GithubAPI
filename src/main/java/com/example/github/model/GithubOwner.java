package com.example.github.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GithubOwner {
    private String nameOwner;
    private String name;
    private Boolean fork;
    private List<Branch> branches;
}

package com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PullRequestResponse {
    private String id;
    private String url;
    private String body;
}

package com.papaco.papacothirdpartyclientservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PullRequestCountResponse {
    private UUID projectId;
    private UUID mateId;
    private Long count;
}

package com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GithubSearchResponse {
    @JsonProperty("total_count")
    private long totalCount;

    @JsonProperty("incomplete_results")
    private boolean incompleteResults;

    @JsonProperty("items")
    private List<CodeStoreGithubResponse> codeStores;

    public boolean isValid() {
        return totalCount != 0 &&
                !incompleteResults;
    }
}

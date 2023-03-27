package com.papaco.papacothirdpartyclientservice.framework.adapter.output.github;

import com.papaco.papacothirdpartyclientservice.application.dto.CodeStoreFindResponse;
import com.papaco.papacothirdpartyclientservice.application.port.output.CodeStoreClient;
import com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto.CodeStoreGithubResponse;
import com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto.GithubSearchResponse;
import com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto.PullRequestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
public class GithubClient implements CodeStoreClient {
    @Value("${api.client.github.base-uri}")
    private String baseUri;
    private final RestTemplate githubRestTemplate;

    public GithubClient(@Qualifier("githubRestTemplate") RestTemplate githubRestTemplate) {
        this.githubRestTemplate = githubRestTemplate;
    }

    @Override
    public Page<CodeStoreFindResponse> fetchCodeStoresByMemberName(Pageable page, String memberName) {
        GithubRequest githubRequest = new GithubRequest(baseUri, GithubURIs.SEARCH_REPOSITORIES);
        githubRequest.addQueryParam("q", "user", memberName);
        githubRequest.addPageParams(page);
        githubRequest.addSortParam("updated", "desc");

        URI uri = githubRequest.build().getUri();
        ResponseEntity<GithubSearchResponse> response = githubRestTemplate.getForEntity(uri, GithubSearchResponse.class);
        GithubSearchResponse githubSearchResponse = Objects.requireNonNull(response.getBody());
        if (!githubSearchResponse.isValid()) {
            return new PageImpl<>(Collections.emptyList());
        }

        List<CodeStoreGithubResponse> githubResponses = githubSearchResponse.getCodeStores();
        PageRequest pageRequest = PageRequest.of(page.getPageNumber(), githubResponses.size(), page.getSort());

        List<CodeStoreFindResponse> findResponses = githubResponses.stream()
                .map(CodeStoreGithubResponse::toCodeStoreFindResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(findResponses, pageRequest, githubSearchResponse.getTotalCount());
    }

    @Override
    public long fetchCountPullRequests(String memberName, String codeStoreName) {
        GithubRequest githubRequest = new GithubRequest(baseUri, GithubURIs.LIST_PULL_REQUESTS);
        githubRequest.addPathParam("owner", memberName);
        githubRequest.addPathParam("repo", codeStoreName);
        URI uri = githubRequest.build().getUri();
        ResponseEntity<List<PullRequestResponse>> response =
                githubRestTemplate.exchange(
                        uri,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<PullRequestResponse>>() {}
                );
        return Objects.requireNonNull(response.getBody()).size();
    }
}

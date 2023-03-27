package com.papaco.papacothirdpartyclientservice.framework.adapter.output.github;

import com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto.CodeStoreGithubResponse;

import java.util.Arrays;
import java.util.List;

public class CodeStoreGithubResponseFixture {
    public static final List<CodeStoreGithubResponse> CODE_STORES;

    static {
        CODE_STORES = Arrays.asList(
                new CodeStoreGithubResponse("1", "papaco"),
                new CodeStoreGithubResponse("2", "papaco-member-service"),
                new CodeStoreGithubResponse("3", "papaco-auth-service")
        );
    }
}

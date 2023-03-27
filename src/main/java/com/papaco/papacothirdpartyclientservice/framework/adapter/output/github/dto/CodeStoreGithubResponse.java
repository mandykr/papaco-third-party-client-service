package com.papaco.papacothirdpartyclientservice.framework.adapter.output.github.dto;

import com.papaco.papacothirdpartyclientservice.application.dto.CodeStoreFindResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CodeStoreGithubResponse {
    private String id;
    private String name;

    public CodeStoreFindResponse toCodeStoreFindResponse() {
        return new CodeStoreFindResponse(id, name);
    }
}

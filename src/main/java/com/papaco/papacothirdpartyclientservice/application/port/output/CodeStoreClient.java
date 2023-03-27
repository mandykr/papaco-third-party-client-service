package com.papaco.papacothirdpartyclientservice.application.port.output;

import com.papaco.papacothirdpartyclientservice.application.dto.CodeStoreFindResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodeStoreClient {

    Page<CodeStoreFindResponse> fetchCodeStoresByMemberName(Pageable page, String memberName);
    long fetchCountPullRequests(String memberName, String codeStoreName);
}

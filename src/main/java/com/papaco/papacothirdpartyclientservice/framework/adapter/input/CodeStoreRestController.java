package com.papaco.papacothirdpartyclientservice.framework.adapter.input;

import com.papaco.papacothirdpartyclientservice.application.dto.CodeStoreFindResponse;
import com.papaco.papacothirdpartyclientservice.application.usecase.CodeStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CodeStoreRestController {
    private final CodeStoreUseCase codeStoreUseCase;

    @GetMapping("/code-stores/{memberName}")
    public ResponseEntity<Page<CodeStoreFindResponse>> findCodeStoresByMemberName(
            @PageableDefault(size = 10, page = 0, sort = "updated") Pageable page,
            @PathVariable String memberName) {
        Page<CodeStoreFindResponse> codeStores = codeStoreUseCase.findCodeStores(page, memberName);
        return ResponseEntity.ok().body(codeStores);
    }

    @GetMapping("/code-stores/{memberName}/{codeStoreName}/pulls/count")
    public ResponseEntity<Long> fetchCountPullRequests(
            @PathVariable String memberName,
            @PathVariable String codeStoreName) {
        long count = codeStoreUseCase.fetchCountPullRequests(memberName, codeStoreName);
        return ResponseEntity.ok().body(count);
    }
}

package com.papaco.papacothirdpartyclientservice.application.port.input;

import com.papaco.papacothirdpartyclientservice.application.dto.CodeStoreFindResponse;
import com.papaco.papacothirdpartyclientservice.application.port.output.CodeStoreClient;
import com.papaco.papacothirdpartyclientservice.application.usecase.CodeStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CodeStoreService implements CodeStoreUseCase {
    private final CodeStoreClient codeStoreClient;

    @Override
    public Page<CodeStoreFindResponse> findCodeStores(Pageable page, String memberName) {
        return codeStoreClient.fetchCodeStoresByMemberName(page, memberName);
    }
}

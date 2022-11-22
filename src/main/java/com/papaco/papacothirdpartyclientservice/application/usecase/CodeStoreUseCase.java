package com.papaco.papacothirdpartyclientservice.application.usecase;

import com.papaco.papacothirdpartyclientservice.application.dto.CodeStoreFindResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodeStoreUseCase {
    Page<CodeStoreFindResponse> findCodeStores(Pageable page, String memberName);
}

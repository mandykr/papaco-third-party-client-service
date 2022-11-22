package com.papaco.papacothirdpartyclientservice.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.papaco.papacothirdpartyclientservice.acceptance.RepositorySteps.리포지토리_목록_조회_요청;
import static com.papaco.papacothirdpartyclientservice.acceptance.RepositorySteps.리포지토리_목록_조회됨;

class RepositoryAcceptanceTest extends AcceptanceTest {

    /**
     * Feature: 리포지토리 목록을 조회한다
     *
     *   Scenario: 리포지토리 목록을 조회
     *     When 리포지토리 목록 조회 요청
     *     Then 리포지토리 목록 조회됨
     */
    @DisplayName("리포지토리 목록을 조회한다")
    @Test
    void fetch() {
        ExtractableResponse<Response> findRepositoriesResponse = 리포지토리_목록_조회_요청("mandykr");
        리포지토리_목록_조회됨(findRepositoriesResponse);
    }
}

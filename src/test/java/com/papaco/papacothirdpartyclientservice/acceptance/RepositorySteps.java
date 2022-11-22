package com.papaco.papacothirdpartyclientservice.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorySteps {
    private static final String CODE_STORE_ENDPOINT = "/code-stores";

    public static ExtractableResponse<Response> 리포지토리_목록_조회_요청(String memberName) {
        return RestAssured.given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("memberName", memberName)
                .when().get(CODE_STORE_ENDPOINT + "/{memberName}")
                .then().log().all().extract();
    }

    public static void 리포지토리_목록_조회됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getList("content")).isNotEmpty();
    }
}

package com.search.business;

import static com.search.business.rest.RestUtil.BUSINESS_BASE_PATH;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BusinessIntegrationTests {

    private static final String PATH = BUSINESS_BASE_PATH + "/";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void getBusinessInfo_whenInvalidLengthId_notFound() {
        get(PATH + "invalidId")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void getBusinessInfo_whenNonExistentId_notFound() {
        get(PATH + "GXvPAor1ffNffF0f5PTGfw")
                .then()
                .assertThat()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getBusinessInfo_happyPath() {
        String validId = "GXvPAor1ifNfpF0U5PTG0w";

        get(PATH + validId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("name", notNullValue())
                .body("address", notNullValue())
                .body("openingHours", notNullValue());
    }
}

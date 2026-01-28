package org.example.tests.auth;
import org.example.base.BaseTest;
import org.example.core.http.impl.RestAssuredHttpClient;
import org.example.service.auth.AuthService;
import org.example.service.auth.impl.AuthServiceImpl;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AuthTokenTest extends BaseTest {

    @Test
    public void shouldGenerateTokenSuccessfully() {

        AuthService authService = new AuthServiceImpl(new RestAssuredHttpClient());

        String token = authService.createToken();

        assertThat(token, notNullValue());
        assertThat(token.length(), greaterThan(5));
    }
}

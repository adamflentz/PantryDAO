package com.adamlentz.pantryDao.clients;

import com.adamlentz.pantryDao.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthClient {

    String requestUrl;

    @Autowired
    public AuthClient(@Value("${authservice.serviceurl}") String requestUrl) {
        this.requestUrl = requestUrl;
    }
    public UserPrincipal retrieveUserDetails(String bearerToken) {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", bearerToken);
        HttpEntity entity = new HttpEntity(header);

        ResponseEntity<UserPrincipal> userDetailsResponseEntity = new RestTemplate().exchange(requestUrl, HttpMethod.GET, entity, UserPrincipal.class);
        return userDetailsResponseEntity.getBody();
    }
}

package com.search.business.service;

import com.search.business.exception.InternalApiException;
import com.search.business.exception.NotFoundException;
import com.search.business.model.BusinessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static java.lang.String.format;

@Service
public class OpenHoursApi {

    @Value("${hours-api.uri}")
    private String uri;

    @Autowired
    private WebClient webClient;

    public BusinessInfo getBusinessInfo(String businessId) {

        return webClient.get()
                .uri(format("%s%s", uri, businessId))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(BusinessInfo.class);
                    } else if (clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)) {
                        throw new NotFoundException(format("Business with id = %s not found.", businessId));
                    } else {
                        throw new InternalApiException();
                    }
                }).block();
    }
}

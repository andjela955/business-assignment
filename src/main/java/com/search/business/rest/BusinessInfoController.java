package com.search.business.rest;

import com.search.business.service.BusinessInfoService;
import com.search.business.model.BusinessInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.search.business.rest.Common.BUSINESS_BASE_PATH;

@RestController
@RequiredArgsConstructor
public class BusinessInfoController {

    private final BusinessInfoService businessInfoService;

    @GetMapping(BUSINESS_BASE_PATH + "/{id}")
    public ResponseEntity<BusinessInfo> getBusinessInfo(@PathVariable("id") String businessId) {
        return ResponseEntity.ok(businessInfoService.getBusinessInfo(businessId));
    }
}

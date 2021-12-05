package com.search.business.service;

import com.search.business.model.BusinessInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessInfoService {

    private final OpenHoursApi openHoursApi;

    public BusinessInfo getBusinessInfo(String businessId) {
        return openHoursApi.getBusinessInfo(businessId);
    }
}

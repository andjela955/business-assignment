package com.search.business.rest;

import com.search.business.exception.InvalidInputException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RestUtil {

    public static final String VERSION = "v1";
    public static final String BUSINESS_BASE_PATH = VERSION + "/businesses";
    public static final int ID_LENGTH = 22;

    public static void checkId(String id) {
        if (id.length() != ID_LENGTH) {
            throw new InvalidInputException(format("Invalid businessId length. Length must: %s.", ID_LENGTH));
        }
    }
}

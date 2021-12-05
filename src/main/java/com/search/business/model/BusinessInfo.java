package com.search.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessInfo {

    private String name;
    private String address;
    private OpeningHours openingHours;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("displayed_what")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("displayed_where")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("openingHours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    @JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    @Data
    private static class OpeningHours {
        private DayHours days;
    }

    @Data
    public static class DayHours {
        private List<HourInfo> monday;
        private List<HourInfo> tuesday;
        private List<HourInfo> wednesday;
        private List<HourInfo> thursday;
        private List<HourInfo> friday;
        private List<HourInfo> saturday;
        private List<HourInfo> sunday;
    }

    @Data
    public static class HourInfo {
        private String start;
        private String end;
        private String type;
    }
}

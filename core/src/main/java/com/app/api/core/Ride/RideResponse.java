package com.app.api.core.Ride;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RideResponse {

    @JsonProperty
    private String rideId = null;

    @JsonProperty
    private String customerId = null;

    @JsonProperty
    private String status = null;

    @JsonProperty
    private String driverId = null;

    @JsonProperty
    private Timestamp requestTime = null;

    @JsonProperty
    private Timestamp ongoingTime = null;

    @JsonProperty
    private Timestamp completeTime = null;

}

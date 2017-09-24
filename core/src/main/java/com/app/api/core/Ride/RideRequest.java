package com.app.api.core.Ride;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RideRequest {

    @JsonProperty
    private String rideId = null;

    @JsonProperty
    private String customerId = null;

}

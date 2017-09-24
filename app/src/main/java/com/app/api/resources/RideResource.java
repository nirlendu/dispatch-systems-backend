package com.app.api.resources;

import com.google.inject.Inject;
import com.app.api.core.Ride.RideResponse;
import com.app.api.logic.RideLogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/auth")
public class RideResource {

    private RideLogic rideLogic;

    @Inject
    public RideResource(RideLogic rideLogic) {
        this.rideLogic = rideLogic;
    }

    @GET
    @Path("/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RideResponse> getRides() throws Exception {

        List<RideResponse> rides = rideLogic.getRides();
        return rides;
    }

}

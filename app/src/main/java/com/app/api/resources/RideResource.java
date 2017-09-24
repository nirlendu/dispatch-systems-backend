package com.app.api.resources;

import com.app.api.core.Ride.RideRequest;
import com.google.inject.Inject;
import com.app.api.core.Ride.RideResponse;
import com.app.api.logic.RideLogic;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/ride")
public class RideResource {

    private RideLogic rideLogic;

    @Inject
    public RideResource(RideLogic rideLogic) {
        this.rideLogic = rideLogic;
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertRide(
            RideRequest rideRequest
    ){
        String rideId = rideLogic.insertRide(
                rideRequest.getRideId(),
                rideRequest.getCustomerId()
        );

        return Response.ok(rideId, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/driver/{driverId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<RideResponse> getRidesByDriver(
            @PathParam("driverId") String driverId
    ) {
        List<RideResponse> rides = rideLogic.getRidesByDriver(driverId);
        return rides;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RideResponse> getRides(){
        List<RideResponse> rides = rideLogic.getRides();
        return rides;
    }

}

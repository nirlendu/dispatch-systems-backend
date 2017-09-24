package com.app.api.logic;

import com.app.api.core.Ride.RideResponse;
import com.app.api.dao.RideDao;
import com.google.common.base.Throwables;
import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;

public class RideLogic {

    private RideDao rideDao;
    private static Logger logger = LogManager.getLogger(RideLogic.class);

    @Inject
    public RideLogic(RideDao rideDao) {
        this.rideDao = rideDao;
    }

    public String insertRide(
            String rideId,
            String customerId
    ){
        try {

            rideDao.insertRide(
                    rideId,
                    customerId
            );
            return rideId;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

    public List<RideResponse> getRidesByDriver(
            String driverId
    ){
        try {

            this.completeRide();
            List<RideResponse> rides = rideDao.getRidesByDriver(driverId);

            return rides;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

    public Integer currentOngoingRides(
            String driverId
    ){
        try {

            List<RideResponse> ongoingRides = rideDao.getOngoingRides(
                    driverId
            );
            return ongoingRides.size();

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

    public String acceptRide(
            String rideId,
            String driverId
    ){
        try {

            if(currentOngoingRides(driverId) > 0){
                return null;
            }

            rideDao.acceptRide(
                    rideId,
                    new Timestamp(System.currentTimeMillis()),
                    driverId
            );
            return rideId;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

    public void completeRide(){
        try {

            rideDao.completeRide(
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis() - 5*60*1000)
            );

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
        }
    }

    public List<RideResponse> getRides(){
        try {

            this.completeRide();
            List<RideResponse> rides = rideDao.getRides();

            return rides;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

}

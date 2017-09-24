package com.app.api.logic;

import com.google.common.base.Throwables;
import com.google.inject.Inject;
import com.app.api.core.Ride.RideResponse;
import com.app.api.dao.RideDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RideLogic {

    private RideDao rideDao;
    private static Logger logger = LogManager.getLogger(RideLogic.class);

    @Inject
    public RideLogic(RideDao rideDao) {
        this.rideDao = rideDao;
    }


    public List<RideResponse> getRides() throws Exception{
        try {

            List<RideResponse> rides = rideDao.getRides();

            return rides;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

}

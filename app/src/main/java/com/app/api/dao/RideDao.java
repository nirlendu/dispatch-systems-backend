package com.app.api.dao;

import com.app.api.core.Ride.RideResponse;
import com.app.api.mapper.RideMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import ru.vyarus.guicey.jdbi.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi.tx.InTransaction;

import java.util.List;

@JdbiRepository
@InTransaction
public interface RideDao {

    @SqlUpdate("INSERT INTO `Ride` (`RideId`, `CustomerId`) VALUES ( :rideId, :customerId)")
    void insertRide(
            @Bind("rideId") String rideId,
            @Bind("customerId") String customerId
    );

    @SqlQuery("SELECT * FROM `Ride` WHERE `Status` = `WAITING` OR DriverId = :driverId ")
    @Mapper(RideMapper.class)
    List<RideResponse> getRidesByDriver(
            @Bind("customerId") String driverId
    );

    @SqlQuery("SELECT * FROM `Ride`")
    @Mapper(RideMapper.class)
    List<RideResponse> getRides( );

}

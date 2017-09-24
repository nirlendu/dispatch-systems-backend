package com.app.api.mapper;

import com.app.api.core.Ride.RideResponse;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RideMapper implements ResultSetMapper<RideResponse>{

    public RideResponse map(int i, ResultSet resultSet, StatementContext statementContext)throws SQLException {
        return new RideResponse(
                resultSet.getString("rideId"),
                resultSet.getString("customerId"),
                resultSet.getString("status"),
                resultSet.getString("driverId"),
                resultSet.getTimestamp("requestTime"),
                resultSet.getTimestamp("ongoingTime"),
                resultSet.getTimestamp("completeTime")
        );
    }
}



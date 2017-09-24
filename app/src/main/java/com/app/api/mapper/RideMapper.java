package com.app.api.mapper;

import com.app.api.core.Ride.RideResponse;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RideMapper implements ResultSetMapper<RideResponse>{

    public RideResponse map(int i, ResultSet resultSet, StatementContext statementContext)throws SQLException {
        return new RideResponse(
                resultSet.getString("RideId"),
                resultSet.getString("CustomerId"),
                resultSet.getString("Status"),
                resultSet.getString("DriverId"),
                resultSet.getTimestamp("RequestTime"),
                resultSet.getTimestamp("OngoingTime"),
                resultSet.getTimestamp("CompleteTime")
        );
    }
}



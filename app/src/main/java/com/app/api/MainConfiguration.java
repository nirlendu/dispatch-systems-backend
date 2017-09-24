package com.app.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MainConfiguration extends Configuration{

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    private final String DATABASE_CONFIG = "database";

    @JsonProperty(DATABASE_CONFIG)
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty(DATABASE_CONFIG)
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}

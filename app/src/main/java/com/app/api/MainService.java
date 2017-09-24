package com.app.api;

import com.app.api.module.DaoModule;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.guicey.jdbi.JdbiBundle;

public class MainService extends Application<MainConfiguration> {

    private static String RESOURCE_PACKAGE = "com.app.api.resources";

	public static void main(String[] args) throws Exception {
	    new MainService().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<MainConfiguration> bootstrap) {

        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(RESOURCE_PACKAGE)
                .bundles(
                        JdbiBundle.<MainConfiguration>forDatabase(
                                (configuration, environment) -> configuration.getDataSourceFactory()
                        )
                )
                .modules(new DaoModule())
                .build());

        // used for manual run to init db
        bootstrap.addBundle(new MigrationsBundle<MainConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(MainConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

	}

  	@Override
	public void run(MainConfiguration configuration, Environment environment) throws Exception {
    }

}

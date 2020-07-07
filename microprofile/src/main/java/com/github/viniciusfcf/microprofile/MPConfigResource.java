package com.github.viniciusfcf.microprofile;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.spi.ConfigSource;

@Path("/mp-config")
public class MPConfigResource {

    @Inject
    private Config config;

    @GET
    @Path("config-sources")
    @Produces(MediaType.TEXT_PLAIN)
    public String methodname() {
        config = ConfigProvider.getConfig();
        Iterable<ConfigSource> configSources = config.getConfigSources();
        StringBuilder sb = new StringBuilder();
        for (ConfigSource configSource : configSources) {
            sb.append("\nNOME: ").append(configSource.getName())
            .append("\n ORDINAL: ").append(configSource.getOrdinal())
            .append("\n PropertyNames: ").append(configSource.getPropertyNames());
        }
        return sb.toString();
    }
}
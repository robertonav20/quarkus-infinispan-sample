package org.acme;

import org.infinispan.client.hotrod.RemoteCache;
import io.quarkus.infinispan.client.Remote;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cache")
public class CacheResource {

    @Remote("simple-cache")
    private RemoteCache<String, String> cache;

    @GET
    @Path("/{key}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("key") String key) {
        return cache.get(key);
    }

    @PUT
    @Path("/{key}")
    @Produces(MediaType.TEXT_PLAIN)
    public String put(String key, String value) {
        return cache.put(key, value);
    }
}
package org.acme;

import io.quarkus.infinispan.client.Remote;
import org.infinispan.client.hotrod.RemoteCache;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cache")
public class CacheResource {

    @Inject
    @Remote("simpleCache")
    RemoteCache<String, String> cache;

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
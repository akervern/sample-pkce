package com.nuxeo.stats;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logmanager.Logger;
import org.jboss.resteasy.spi.HttpRequest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.security.Principal;

@Path("/api")
public class ApiResource {

    @Context
    protected UriInfo uriInfo;
    @Context
    protected HttpRequest request;
    @Context
    protected Response response;
    Logger logger = Logger.getLogger(ApiResource.class.getName());
    @Inject
    JsonWebToken jwt;
    @Context
    SecurityContext ctx;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {

        Principal caller = ctx.getUserPrincipal();
        String name = caller == null ? "anonymous" : caller.getName();
        boolean hasJWT = jwt != null;
        String helloReply = String.format("hello + %s, isSecure: %s, authScheme: %s, hasJWT: %s", name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJWT);

        return "{\"res\": \"ouiii\", \"jwt\": \"" + helloReply + "\"}";
    }
}

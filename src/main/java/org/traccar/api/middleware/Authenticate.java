package org.traccar.api.middleware;

import org.traccar.Main;
import org.traccar.database.StatisticsManager;
import org.traccar.api.auth.UserPrincipal;
import org.traccar.api.auth.Auth;
import org.traccar.api.auth.JWT;
import org.traccar.api.routes.Guard;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.*;
import io.jsonwebtoken.Claims;

public class Authenticate implements ContainerRequestFilter {

    private Map<String, Object> response = new LinkedHashMap<>();
    private Map<String, Object> data = new LinkedHashMap<>();
    
    @Override
    public void filter(ContainerRequestContext request) {
    
        Guard guard = Main.getInjector().getInstance(Guard.class);
        String path = request.getUriInfo().getAbsolutePath().getPath();
        if(guard.isGranted("all", request.getMethod(), path)) {
            return;
        }
        
        String authHeader = request.getHeaderString("Authorization");
        if (authHeader == null || authHeader.isEmpty()) {
            data.put("message", "Please set the Authorization header");
            response.put("success", false);
            response.put("error", data);
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(response).build());
            return;
        }
        
        String[] auth = authHeader.split("\\s+");
        if(auth.length != 2 || !auth[0].toLowerCase().equals("bearer")) {
            data.put("message", "Only Bearer Token is Allowed");
            response.put("success", false);
            response.put("error", data);
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(response).build());
            return;
        }
        
        Map<String, Object> user = JWT.decodeJWT(auth[1]);
        if (user == null) {
            data.put("message", "Invalid Token");
            response.put("success", false);
            response.put("error", data);
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(response).build());
            return;
        }
        
        if (!guard.isGranted(user.get("guard").toString(), request.getMethod(), path)) {
            data.put("message", "Permission Denied");
            response.put("success", false);
            response.put("error", data);
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(response).build());
            return;
        }
        
        Main.getInjector().getInstance(StatisticsManager.class).registerRequest(Long.parseLong(user.get("id").toString()));
        SecurityContext securityContext = new Auth(new UserPrincipal(user));
        request.setSecurityContext(securityContext);
    }

}

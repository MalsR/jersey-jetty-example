package jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/info")
public class InfoPageResource {

    @GET
    public Response getInfo() {
        return Response.ok("OK").build();
    }
}

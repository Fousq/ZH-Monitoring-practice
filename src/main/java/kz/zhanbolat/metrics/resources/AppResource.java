package kz.zhanbolat.metrics.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import kz.zhanbolat.metrics.api.HelloObject;
import kz.zhanbolat.metrics.core.HelloObjectRegister;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Resource
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class AppResource {

    private HelloObjectRegister helloObjectRegister;

    public AppResource(HelloObjectRegister helloObjectRegister) {
        this.helloObjectRegister = helloObjectRegister;
    }

    @GET
    @Path("/hello")
    @Timed
    @Metered(name = "helloMetered")
    @ExceptionMetered(name = "messageExceptionMetered", cause = IllegalArgumentException.class)
    public HelloObject hello(@QueryParam("message") String message) {
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message empty");
        }
        HelloObject hello = new HelloObject("hello" + message);
        helloObjectRegister.add(hello);
        return hello;
    }
}

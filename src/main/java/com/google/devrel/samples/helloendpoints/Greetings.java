package com.google.devrel.samples.helloendpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.api.users.User;

import javax.inject.Named;
import java.util.ArrayList;

/**
 * Defines v1 of a helloworld API, which provides simple "greeting" methods.
 */
@Api(
    name = "helloworld",
    version = "v1",
    scopes = {Constants.EMAIL_SCOPE},
    clientIds = {com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID}
)
public class Greetings {
  public static ArrayList<HelloGreeting> greetings = new ArrayList<HelloGreeting>();

  static {
    greetings.add(new HelloGreeting("hello world!"));
    greetings.add(new HelloGreeting("goodbye world!"));
  }

  public HelloGreeting getGreeting(@Named("id") Integer id) {
    return greetings.get(id);       
  }

  @ApiMethod(name = "greetings.authed", path = "greeting/authed")
  public HelloGreeting authedGreeting(User user) throws Exception {
    if( user == null ) {
        throw new Exception( "I hate you" );
    }
    HelloGreeting response = new HelloGreeting("hello " + user.getEmail());
    return response;
  }

  @ApiMethod(name = "greetings.multiply", httpMethod = "post")
  public HelloGreeting insertGreeting(@Named("times") Integer times, HelloGreeting greeting) {
    HelloGreeting response = new HelloGreeting();
    StringBuilder responseBuilder = new StringBuilder();
    for (int i = 0; i < times; i++) {
      responseBuilder.append(greeting.getMessage());
    }
    response.setMessage(responseBuilder.toString());
    return response;
  }  
}
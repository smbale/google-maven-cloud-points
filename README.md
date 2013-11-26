google-maven-cloud-points
=================================================================================================

The google cloud points using maven requires some step by step creation. 
This because the archetype it is not ready to go as excepted. 
The step by step creation process is described here https://developers.google.com/appengine/docs/python/endpoints/. 

This project it is a working version of the Google Cloud Points - Hello End Points Demo Project.

=================================================================================================

App Engine Java Application
Copyright (C) 2010-2012 Google Inc.

## Skeleton application for use with App Engine Java.

Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 6+ in order to run.

To build, run

    mvn package

Building will run the tests, but to explicitly run tests you can use the test target

    mvn test

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.  Just run the command.

    mvn appengine:devserver

For further information, consult the [Java App Engine](https://developers.google.com/appengine/docs/java/overview) documentation.

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine

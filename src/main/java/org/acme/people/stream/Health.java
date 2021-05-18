package org.acme.people.stream;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;


@ApplicationScoped
public class Health {

   

	// Retrieving from topic
    @Incoming("heartrate")               
    @Outgoing("heart-rate-stream")      
    @Broadcast                       
    public String process(String name) {
        int honorific = (int)Math.floor((Math.random()*(29)+72));
        return  name +" Heart Rate : "+honorific;
    }
    
    @Incoming("bloodoxygen")               
    @Outgoing("blood-oxygen-stream")      
    @Broadcast                       
    public String processtwo(String name) {
        int honorific = (int)Math.floor((Math.random()*(60)+110));
        return  name +" Blood Oxygen  : "+honorific;
    }
    @Incoming("bloodpressure")               
    @Outgoing("blood-pressure-stream")      
    @Broadcast                       
    public String processthree(String name) {
        int honorific = (int)Math.floor((Math.random()*(5)+90));
        return  name +" : Blood Pressure  : "+honorific+"%";
    }
  
}
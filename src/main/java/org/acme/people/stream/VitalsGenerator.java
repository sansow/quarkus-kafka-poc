package org.acme.people.stream;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

@ApplicationScoped
public class VitalsGenerator {

	// Sending to topic 
    @Outgoing("generated-heart-name")           
    public Flowable<String> generate() {  
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> NameGenerator.generate());
    }
    
    
    @Outgoing("generated-blood-name")           
    public Flowable<String> generateBloodPressure() {  
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> "blood pressure random name");
    }
    
    @Outgoing("generated-blood-oxygen-name")           
    public Flowable<String> generateBloodOxygen() {  
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> "blood oxygen random name");
    }

}
package com.mulesoft.training;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase
{
    @Test
    public void mavenFlow_ReturnsHelloMaven() throws Exception
    {
        runFlowAndExpect("mavenFlow", "Hello Maven");
    }
    
    @Test
    public void retrieveFlights_ContextType() throws Exception
    {
    	String expectedResult = "application/json";
    	
    	MuleEvent event = runFlow("retrieveFlights");
    	String result = event.getMessage().getOutboundProperty("Content-Type");
    	assertEquals(expectedResult, result);
    }
    
    @Override
    protected String getConfigFile()
    {
        return "maven-project.xml";
    }
}

package com.nemsolutions.auracommons.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;

@Component("allExceptionListener")
public class AllExceptionListener extends FlowExecutionListenerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(AllExceptionListener.class);   
	
    @Override
    public void exceptionThrown(RequestContext context, FlowExecutionException exception) {
    	
    	log.error("ERROR", exception);
    	
    }

}

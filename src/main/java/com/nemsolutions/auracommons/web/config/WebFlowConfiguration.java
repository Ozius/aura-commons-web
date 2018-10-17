package com.nemsolutions.auracommons.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.faces.webflow.JsfFlowHandlerAdapter;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

import com.nemsolutions.auracommons.web.exception.AllExceptionListener;

@Configuration
public class WebFlowConfiguration extends AbstractFacesFlowConfiguration {

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder()
				.setBasePath("/flows")
				.addFlowLocationPattern("/**/*.xml")
				.setFlowBuilderServices(flowBuilderServices())
				.build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder()
				.setDevelopmentMode(true)
				.build();
	}

	@Bean
	public FlowExecutor flowExecutor(AllExceptionListener allExceptionListener) {
		return getFlowExecutorBuilder(flowRegistry())
				.addFlowExecutionListener(new FlowFacesContextLifecycleListener())
				.addFlowExecutionListener(allExceptionListener)
				.setMaxFlowExecutionSnapshots(0)
				.build();
	}
	
	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
		handlerMapping.setOrder(-1);
		handlerMapping.setFlowRegistry(flowRegistry());
		return handlerMapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter(@Autowired AllExceptionListener allExceptionListener) {
		JsfFlowHandlerAdapter adapter = new JsfFlowHandlerAdapter();
		adapter.setFlowExecutor(flowExecutor(allExceptionListener));
		return adapter;
	}

}

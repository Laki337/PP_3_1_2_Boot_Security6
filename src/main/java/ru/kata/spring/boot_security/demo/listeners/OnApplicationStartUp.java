package ru.kata.spring.boot_security.demo.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnApplicationStartUp {
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.err.println("ZAPYCK");
	}
	

}

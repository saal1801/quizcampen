package com.quizcampen.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class QuizApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public QuizApplication() {

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			public void run() {
				System.out.println("Who called System.exit()..");
			}

		}));

		this.singletons.add(new QuizcampenServiceResource());

	}

	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	public Set<Object> getSingletons() {
		return this.singletons;
	}

}

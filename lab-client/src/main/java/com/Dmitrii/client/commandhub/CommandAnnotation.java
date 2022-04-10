package com.Dmitrii.client.commandhub;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Аннотация для комманд.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandAnnotation {
	
	String description();
	boolean needWorker();
	boolean needId();
	boolean needPath();
}

/**
 * 
 */
package edu.westga.greeting.model;

/**
 * The EnglishGreetingBean class generates a greeting
 * in English.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 * 
 */
public class EnglishGreetingBean implements IGreeting { 

	/**
	 * Instantiates an EnglishGreetingBean object.
	 */
	public EnglishGreetingBean() {
	}

	
	/**
	 * @see edu.westga.greeting.model.IGreeting#getGreeting()
	 */
	public String getGreeting() {
		return "Hello. How are you?";
	}

}

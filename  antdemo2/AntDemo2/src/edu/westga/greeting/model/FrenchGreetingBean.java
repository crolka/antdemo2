/**
 * 
 */
package edu.westga.greeting.model;

/**
 * The FrenchGreetingBean class generates a greeting
 * in French.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 *
 */
public class FrenchGreetingBean implements IGreeting {

	/**
	 * Instantiates a FrenchGreetingBean object.
	 */	
	public FrenchGreetingBean() {
	}
	
	/**  
	 * @see edu.westga.greeting.model.IGreeting#getGreeting()
	 */
	public String getGreeting() {
		return "Bonjour. Ca va bien?";
	}

}

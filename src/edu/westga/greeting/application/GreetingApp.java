/**
 * 
 */
package edu.westga.greeting.application;

import edu.westga.greeting.model.GreetingFactory;
import edu.westga.greeting.model.IGreeting;

/**
 * This console application displays a greeting in any language
 * for which a class that implements IGreeting is defined.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 *
 */
public class GreetingApp {
	
	private String[] commandLineArgs;
	
	
	//************ static application entry point ************
	
	/**
	 * Executes the GreetingApp application.
	 * <p>
	 * If a language name is supplied as the first command
	 * line argument, the greeting will be in that language.
	 * Otherwise, the environment variable "language" determines
	 * the language of the greeting. 
	 * 
	 * @param args	args[0] may be used to specify 
	 * 				the language of the greeting
	 */
	public static void main(String[] args) {
		
		GreetingApp theApp = new GreetingApp(args);
		theApp.execute();

	}
	
	
	//******************** private methods *******************
	
	// Instantiates a new GreetingApp object with the
	// given command line arguments.
	private GreetingApp(String[] commandLineArgs) {
		this.commandLineArgs = commandLineArgs;
	}


	// Runs the application. 
	private void execute() {
		
		String language = this.determineLanguage();
		IGreeting greeter = null;
		
		try {
			greeter =       
				GreetingFactory.getGreetingFactory().getGreetingBean(language);
		}
		catch(Exception e) {
			System.out.println("*** ERROR: Invalid language specified. ***");
			System.exit(1);
		}		
		
		System.out.println(greeter.getGreeting());
		
	}

	// Returns the language to be used for the greeting, or
	// null if no language or an invalid language is specified.
	private String determineLanguage() {
		
		String language;
		if (this.commandLineArgs.length > 0) {
			language = this.commandLineArgs[0];
		}
		else {
			language = System.getenv("language");
		}
		return language;
		
	}
}

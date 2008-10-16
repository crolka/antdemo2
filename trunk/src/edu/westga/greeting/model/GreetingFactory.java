/**
 * 
 */
package edu.westga.greeting.model;

/**
 * The GreetingFactory class instantiates an object
 * of a class that implement interface IGreeting.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 *
 */
public class GreetingFactory {
	
	private static GreetingFactory theFactory;
	
	// Private constructor.
	private GreetingFactory(){
		GreetingFactory.theFactory = null;
	}

    
	/**
	 * Instantiates an object that implements the IGreeting 
	 * interface and generates a greeting in the given language.
	 * 
	 * @param beanLanguage	the name of the language
	 * @return 	if class ("edu.westga.greeting.model." + beanLanguage 
	 * 					 + "GreetingBean") is defined,  <br />
     *     			returns an object of that class,		<br />
     * 			else returns null
	 */
	public IGreeting getGreetingBean(String beanLanguage) 
					 	throws ClassNotFoundException, 
					 		   IllegalAccessException,
					 		   InstantiationException {
		
    	String theClass = null;
    	
    	theClass = "edu.westga.greeting.model." + 
    				   beanLanguage + "GreetingBean";
    	return (IGreeting)Class.forName(theClass).newInstance();
        
    }
    
    /**
     * 
     * @return
     */
    public static GreetingFactory getGreetingFactory() {
    	if (GreetingFactory.theFactory == null) {
    		GreetingFactory.theFactory = new GreetingFactory();
    	}
    	return GreetingFactory.theFactory;
    }


}

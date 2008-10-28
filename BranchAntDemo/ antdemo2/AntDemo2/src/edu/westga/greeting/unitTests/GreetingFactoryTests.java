/**
 * 
 */
package edu.westga.greeting.unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.greeting.model.EnglishGreetingBean;
import edu.westga.greeting.model.FrenchGreetingBean;
import edu.westga.greeting.model.GreetingFactory;
import edu.westga.greeting.model.IGreeting;

/**
 * The GreetingFactoryTests class contains the
 * unit tests for class GreetingFactory.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 *
 */
public class GreetingFactoryTests {

	private GreetingFactory theFactory; 
	
	@Before
	public void setUp() throws Exception {
		this.theFactory = GreetingFactory.getGreetingFactory();
	}

	/**
	 * Test method for 
	 * {@link edu.westga.greeting.model.GreetingFactory#getGreetingBean(java.lang.String)}.
	 */
	@Test
	public void shouldGetEnglishBeanWhenEnglishSpecified() {
		try {
			IGreeting greeter = this.theFactory.getGreetingBean("English");
			assertEquals(EnglishGreetingBean.class, greeter.getClass());
		} 
		catch (ClassNotFoundException e) {
			fail("EnglishGreetingBean class not found");
		} 
		catch (Exception e) {
			fail("Could not instantiate EnglishGreetingBean object");
		}
	}
	
	/**
	 * Test method for 
	 * {@link edu.westga.greeting.model.GreetingFactory#getGreetingBean(java.lang.String)}.
	 */
	@Test
	public void shouldGetFrenchBeanWhenEnglishSpecified() {
		try {
			IGreeting greeter = this.theFactory.getGreetingBean("French");
			assertEquals(FrenchGreetingBean.class, greeter.getClass());
		} 
		catch (ClassNotFoundException e) {
			fail("FrenchGreetingBean class not found");
		} 
		catch (Exception e) {
			fail("Could not instantiate FrenchGreetingBean class");
		} 
	}
	
	/**
	 * Test method for 
	 * {@link edu.westga.greeting.model.GreetingFactory#getGreetingBean(java.lang.String)}.
	 */
	@Test(expected=ClassNotFoundException.class)
	public void shouldThrowClassNotFoundExceptionWhenGarbageSpecified() 
						throws Exception {
		IGreeting greeter = this.theFactory.getGreetingBean("xxxyyy");
		greeter.toString();
	}

}

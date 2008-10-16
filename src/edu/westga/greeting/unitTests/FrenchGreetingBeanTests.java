/**
 * 
 */
package edu.westga.greeting.unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.greeting.model.FrenchGreetingBean;

/**
 * The FrenchGreetingBeanTests class contains the
 * unit tests for class FrenchGreetingBean.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 *
 */
public class FrenchGreetingBeanTests {

	private FrenchGreetingBean theBean;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.theBean = new FrenchGreetingBean();
	}

	/**
	 * Test method for 
	 * {@link edu.westga.greeting.model.FrenchGreetingBean#getGreeting()}.
	 */
	@Test
	public void shouldGetFrenchGreeting() {
		assertEquals("Bonjour. Ca va bien?", theBean.getGreeting());
	}

}

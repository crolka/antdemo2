/**
 * 
 */
package edu.westga.greeting.unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.greeting.model.EnglishGreetingBean;

/**
 * The EnglishGreetingBeanTests class contains the
 * unit tests for class EnglishGreetingBean.
 * 
 * @author CS 6242, Fall 2008
 * @version 0.8
 *
 */
public class EnglishGreetingBeanTests {

	private EnglishGreetingBean theBean;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.theBean = new EnglishGreetingBean();
	}

	/**
	 * Test method for 
	 * {@link edu.westga.greeting.model.EnglishGreetingBean#getGreeting()}.
	 */
	@Test
	public void shouldGetEnglishGreeting() {
		assertEquals("Hello. How are you?", this.theBean.getGreeting());
	}

}

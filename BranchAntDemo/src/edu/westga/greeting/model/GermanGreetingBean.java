package edu.westga.greeting.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GermanGreetingBean implements IGreeting {

	/**
	 * Instantiates an EnglishGreetingBean object.
	 */
	public GermanGreetingBean() {
	}

	
	/**
	 * @see edu.westga.greeting.model.IGreeting#getGreeting()
	 */
	public String getGreeting() {
		Calendar myCal = new GregorianCalendar();
		int hour = myCal.get(Calendar.HOUR_OF_DAY);
		String timeDay = " Tag";
		
		if (hour > 16){
			timeDay = " Abend";
		} else if (hour < 12){
			timeDay = " Morgen";
		}
		
		return "Guten" + timeDay + ".  Wie geht es Ihnen?";
	}
}

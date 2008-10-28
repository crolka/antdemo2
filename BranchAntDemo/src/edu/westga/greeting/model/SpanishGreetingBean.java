package edu.westga.greeting.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SpanishGreetingBean {

	public SpanishGreetingBean(){
		
	}
	
	public String getGreeting(){
		Calendar myCal = new GregorianCalendar();
		int hour = myCal.get(Calendar.HOUR_OF_DAY);
		String timeDay = "Buenos Dias";
		
		if (hour > 18){
			timeDay = "Buenas noches";
		} else if ((hour >= 12) && (hour < 18)){
			timeDay = "Buenas Tardes";
		}
		
		return timeDay + ".  Que Tal?";
	}
}

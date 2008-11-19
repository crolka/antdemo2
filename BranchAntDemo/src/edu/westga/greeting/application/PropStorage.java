package edu.westga.greeting.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropStorage {
	
private String language;
private Properties props;

	public PropStorage(){	
		props = new Properties();
		System.out.println(this.language);
		//storeLanguage();
	}

	public PropStorage(String selectedLanguage){
		this.language = selectedLanguage;
		props = new Properties();
		System.out.println(this.language);
		//storeLanguage();
	}
	
	public void storeLanguage(){
		System.out.println("file write");	
	props.setProperty("language", this.language);
	try {
		props.store(new FileOutputStream(new File("./bin/selection.properties")), "my interesting comment");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public String getStoredLanguage(){
		System.out.println("file read");	
		try {

            props.load(new FileInputStream("./bin/selection.properties"));

            this.language = props.getProperty("message");

            System.out.println(this.language);
             }

            //catch exception in case properties file does not exist

            catch(IOException e)
            {
            e.printStackTrace();
            this.language = "English";
        }		
		return this.language;
	}
}

package com.atasteofhome;

import java.io.File;
import java.net.URI;
import com.atasteofhome.FileUtils.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello there! Andrew Tsai here." );
        File appClassPath=null;
        try{
            Class[] classes=ClassFinder.getClassesInPackage("com.atasteofhome");
            for(int i=0;i<classes.length;i++){
                System.out.println(classes[i].getName());
            }
        	//getResource(app) is null; fix this
        	//appClassPath = new File(App.class.getResource("App").toURI());	
        }catch(Exception e){
        	e.printStackTrace();
        	return;
        }

        if(appClassPath==null){
        	return;
        }
        File[] projectList = appClassPath.listFiles();

        if(projectList==null){
        	return;
        }

        //prompt user to select which project to view/interact with
        System.out.println("Which project would you like to view? (Enter the number corresponding to the desired project)");
        for(int i=0; i<projectList.length; i++){
        	if(projectList[i].isDirectory())
        	System.out.println(i + ": " + projectList[i].getName());
        }

        //loop through the packages in this directory. run the Driver main method of selected package.

	}
}

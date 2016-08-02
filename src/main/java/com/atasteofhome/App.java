package com.atasteofhome;

import java.util.*;
import java.lang.reflect.*;

import com.atasteofhome.fileUtils.*;
import com.atasteofhome.stringUtils.*;
import com.atasteofhome.ui.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "\nHello there! Andrew Tsai here." );
        String [] packages=null;
        try{
            packages = FileFinder.getAllPackages("com.atasteofhome");

            //catch null pointer exceptions
            int test=packages.length;
        }catch(Exception e){
        	e.printStackTrace();
        	return;
        }

        // String[] choices = new String[packages.length+1];
        // choices[0] = "Quit (hit 0 to quit)";
        // System.arraycopy(packages, 0, choices, 1, packages.length);
        
        //prompt user to select which project to view/interact with
        for(int choice=-1;;){
            System.out.println("\n= = = = = = = = = = = = = = =");
            choice = CLI.menu("Which project would you like to view?", packages, true);
            if(choice==-1){
                break;
            }

            System.out.println("\nChoice: " + packages[choice]);
            try{
                //call the function using Method.invoke()
                //get the driver class from the specified package
                Class driver = Class.forName("com.atasteofhome." + packages[choice] + ".Driver");
                //get an instance of said class
                Object driverInstance = driver.newInstance();
                //get the run method from the driver class
                Method driverRun = driver.getDeclaredMethod("run",null);
                //attempt to run it
                driverRun.invoke(driverInstance, null);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println();
            }
            
        }
        

        //loop through the packages in this directory. run the Driver main method of selected package.

        System.out.println("\nThank you for spending time in this humble Java Playground. Have a good one!");
	}
}

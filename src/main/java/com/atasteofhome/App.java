package com.atasteofhome;

import com.atasteofhome.fileUtils.*;
import com.atasteofhome.stringUtils.*;
import com.atasteofhome.ui.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello there! Andrew Tsai here." );
        String [] packages=null;
        try{
            packages=FileFinder.getAllPackages("com.atasteofhome");

            //catch null pointer exceptions
            int test=packages.length;
        }catch(Exception e){
        	e.printStackTrace();
        	return;
        }

        //prompt user to select which project to view/interact with
        System.out.println();
        int choice = CLI.menu("Which project would you like to view?", packages);
        System.out.println("\nChoice: " + packages[choice]);

        //loop through the packages in this directory. run the Driver main method of selected package.

        System.out.println();
	}
}

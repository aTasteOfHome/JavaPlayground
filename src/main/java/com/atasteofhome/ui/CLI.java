package com.atasteofhome.ui;

import java.util.Scanner;
import java.lang.Integer;

/**
*Command line interface
*
*/
public class CLI {

	public static int menu(String header, String[] options, boolean quittable){

		Scanner scan = new Scanner(System.in);
		int ret=-1;

		if(options==null || options.length <=0){
			System.out.println("Error; no choices available.");
			return -1;
		}


		while(true){
			//print out menu items
			System.out.println(header + " Please enter the number corresponding to your choice.");

			//if quittable, add a quit option as option 0.
			if(quittable){
				System.out.println("0: Quit (type 0 to quit)");	
			}
			for(int i=0; i<options.length; i++){

				//change the indices if menu is quittable.
				System.out.println( (quittable ? i+1 : i) + ": " + options[i]);
			}
			System.out.print("> ");

			try{
				String input = scan.nextLine().toLowerCase();

				//exit menu if it is quittable, and if a valid quit option was given.
				if(quittable && (input.equals("q") || input.equals("quit") || input.equals("0")) ){
					return -1;
				}

				ret = Integer.parseInt(input);
				if(ret>=options.length+1 || ret<0 || (!quittable && ret>=options.length)){
					System.out.println("\n~ ~ ~ ~\nNot a valid option; please enter a number between 0 and " + (options.length-1) +", inclusive.\n~ ~ ~ ~");
				}else{
					return (quittable ? ret-1 : ret);
				}
			}catch(Exception e){
				System.out.println("\n~ ~ ~ ~\nUnable to parse input.\n~ ~ ~ ~");
			}
		}
	}
}
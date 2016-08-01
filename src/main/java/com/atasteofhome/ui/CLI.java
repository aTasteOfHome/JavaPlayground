package com.atasteofhome.ui;

import java.util.Scanner;
import java.lang.Integer;

/**
*Command line interface
*
*/
public class CLI {

	public static int menu(String header, String[] options){

		Scanner scan = new Scanner(System.in);
		int ret=-1;

		System.out.println(header + " Please enter the number corresponding to your choice.");

		if(options==null || options.length <=0){
			System.out.println("Error; no choices available.");
			return -1;
		}

		for(int i=0; i<options.length; i++){
			System.out.println(i + ": " + options[i]);
		}
		System.out.print("> ");


		while(true){
			try{
				ret = Integer.parseInt(scan.nextLine());
				if(ret>=options.length || ret<0){
					System.out.println("\nNot a valid option; please enter a number between 0 and " + (options.length-1) +", inclusive.");
				}else{
					return ret;
				}
			}catch(Exception e){
				System.out.println("\nUnable to parse input. Please enter the number corresponding to your choice.");
			}
			System.out.print("> ");
		}
	}
}
package com.atasteofhome.stringUtils;

import java.util.ArrayList;

public class StringSearch{

	public static int[] KMPsearch(String pattern, String text){

		if(pattern==null || pattern=="" || text==null || text==""){
			return null;
		}

		//prefix function, generate table.
		int[] prefixTable = generatePrefixTable(pattern);

		ArrayList<Integer> matchIndices= new ArrayList<Integer>();

		//loop through text
		for(int t=0; t<text.length();){

			//loop through pattern, and compare each pattern character with the corresponding character in the text.
			for(int p=0; p<pattern.length(); p++){
				//at each loop, assume that previous character had been matched

				//if we're at the end of the pattern and the characters match, a match has been found
				if(p==pattern.length()-1 && pattern.charAt(p) == text.charAt(t+p)){
					matchIndices.add(t+p);
					//make use of the prefix table here

				//if the pattern and text don't match
				}else if(pattern.charAt(p) != text.charAt(t+p)){
					//use prefix table
				}
			}
		}

		return StringSearch.toIntArray(matchIndices);
	}

	private static int[] generatePrefixTable(String pattern){
		int[] table = new int[pattern.length()];
		table[0]=-1;
		int counter=0;
		for(int p=1; p<pattern.length(); p++){
			table[p]=counter;
			if(pattern.charAt(p)==pattern.charAt(counter)){
				counter++;
			}else{
				counter=0;
			}
		}

		return table;
	}

	private static int[] toIntArray(ArrayList<Integer> integers){
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++){
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
}
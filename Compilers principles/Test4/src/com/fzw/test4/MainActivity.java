package com.fzw.test4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity {

	private static String line = null;
	private static boolean flag = true;
	private static int i = 0;
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			line = br.readLine();
			funS();
			if(i == line.length()){
				System.out.println("right");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	
	private static void funS() {
		if(line.charAt(i) == 'a'){
			++i;
			funS();
			if(line.charAt(i) == 'e'){
				++i;
				return ;
			}else {
				System.out.println("error");
				System.exit(0);
			}
		}else{
			funB();
		}
		
	}
	
	private static void funB(){
		if(line.charAt(i) == 'b'){
			++i;
			funB();
			if(line.charAt(i) == 'e'){
				++i;
				return ;
			}else{
				System.out.println("error");
				System.exit(0);
			}
		}else{
			funC();
		}
	}

	private static void funC(){
		if(line.charAt(i) == 'c'){
			++i;
			funC();
			if(line.charAt(i) == 'c'){
				++i;
				return;
			}
		}else if(line.charAt(i) == 'd'){
			++i;
			return;
		}else{
			System.out.println("error");
			System.exit(0);
		}
	}
}

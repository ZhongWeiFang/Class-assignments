package com.fzw.test5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity {
	
	private static List<String> Production = new ArrayList<String>();
	private static String Epsilons = "";
	private static boolean change = true;
	private static Map<Character, Integer> eps = new HashMap<Character, Integer>();
	
	
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader(new File("e:\\","test5.txt"));
			BufferedReader br = new BufferedReader(fr);
			//输入产生式
			String string = "";
			while((string =  br.readLine()) != null){
				Production.add(string);
			}
			String str = "";
			for(int j =0;j<Production.size();++j){
				str = Production.get(j);
//				Production[j]  = str;
				Production.set(j, str.replaceAll("->", ""));
				for(int n = 0;n<Production.get(j).length();++n){
					char tmp = Production.get(j).charAt(n);
					if (!Epsilons.contains("" + tmp) && tmp != '$') {
						Epsilons +="" + tmp;
					}
				}
				
			}
			for(int k=0;k<Epsilons.length();++k){
				eps.put(Epsilons.charAt(k), 0);
			}
			while(change){
				change = false;
				for(int count=0;count<Production.size();++count){
					if(Production.get(count).charAt(1) == '$'){
						if(eps.get(Production.get(count).charAt(0)) == 1){
							continue;
						}else {
							eps.put(Production.get(count).charAt(0),1);
							change = true;
						}
					}else{
						boolean flag = false;
						for(int m =1;m<Production.get(count).length() && !flag;++m){
							if(eps.get(Production.get(count).charAt(m)) != 1){
								flag = true;
								break;
							}
						}
						if(flag == false){
							if(eps.get(Production.get(count).charAt(0)) == 1){
								continue;
							}else {
								eps.put(Production.get(count).charAt(0),1);
								change = true;
							}
						}
					}
				}
			}
			
			
			for(int l=0;l<Epsilons.length();++l){
				if(eps.get(Epsilons.charAt(l)) == 1){
					System.out.print(Epsilons.charAt(l));
				}
			}
			System.out.println("");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

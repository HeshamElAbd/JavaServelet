package com.vogella.web.filecounter.randGenJava;
import java.util.Random;

public class RandWordGen {
	public  String getRandWord() {
		String word="";
		try {
			Random rand= new Random();
			int word_length=rand.nextInt(9);
			word_length+=1;
			
			String[] posible_chars= {"a","b","c","d","e","f","g",
					"j","k","l","m"," ","n","q","w","r","t","y","u",
					"i","o","p","s","h","v",".",","};
			
			for(int iter=0;iter!=word_length;iter++) {
				word=word.concat(posible_chars[rand.nextInt(posible_chars.length)]);
			}

		}catch(Exception e) {
			System.out.println("An error has occured ");
			e.printStackTrace();
		}
		return word;
		
		
	}
}

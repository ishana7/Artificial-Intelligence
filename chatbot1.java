

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


//// run in eclipse 

public class chatbot1
{

	
	Map<String,String>nouns=new HashMap<String, String>();
	Map<String,String>welcome=new HashMap<String, String>();
	Map<String,String>farewell=new HashMap<String, String>();
	
	
	boolean exit=false;
	
	ArrayList<String> keywords;
	
	public chatbot1()
	{
		
		
	
		nouns.put("money", "Where??");
		nouns.put("finance", "Many firms provide loan options");
		nouns.put("invest", "Yes,Offcourse.Basically there are many options to invest.Regional investment Banks and shares. In which section would you like to invest?");
		nouns.put("bank", "Yes,Offcourse.Basically there are many options to invest.Regional Banks,Investment Banks In which section would you like to invest?");
		nouns.put("shares", "Which company Shares Tata,SBI,Reliance?");
        nouns.put("tata", "Tata shares price is 128.20 INR");
        nouns.put("sbi", "SBI share price is 256.60 INR");
        nouns.put("reliance", "Reliance share price is 1360.45 INR");
	            
		nouns.put("loan", "Which loan?? Housing ,Personal,Educational.");
        nouns.put("housing", "Which bank would you prefer, SBI, IDBI, Kotak Mahindra, HSBC? i suggest SBI for housing loans.");
        nouns.put("personal", "Which bank would you prefer, SBI, IDBI, Kotak Mahindra, HSBC? i suggest HSBC for Personal loans.");
        nouns.put("educational", "Which bank would you prefer, SBI, IDBI, Kotak Mahindra, HSBC? i suggest IDBI for Educational loans.");
		nouns.put("investment","Well there are many such as UBS,Barclays,HSBC");
        nouns.put("ubs", "UBS offers 10% interest");
        nouns.put("barclays", "Barclays offers 8% interest");
        nouns.put("hsbc", "HSBC offers 12% interest");
		nouns.put("regional", "There are many SBI,IDBI,KotaK Mahindra. Where would you like to invest?");
		nouns.put("sbi", "SBI offers 10% interest");
        nouns.put("idbi", "IDBI offers 8% interest");
        nouns.put("kotak", "Kotak offers 12% interest");
		
		welcome.put("hi","Welcome! How can I help you??");
		welcome.put("hey","hey,how I can help you??");
		welcome.put("hello","hello,How can I help you??");
		welcome.put("thanku", "Welcome");
		
		farewell.put("bye","Thank you, its nice to talk with you. Bye");
		farewell.put("bbye","bbye");
		farewell.put("ok","Do you want to know about anything else?");
		farewell.put("no","Fine. Thank you, its nice to talk with you. Bye");
		
		
		
	}
	
	public static void main(String[] args)
	{
		
		Scanner s=new Scanner(System.in);
		chatbot1 c=new  chatbot1();
		
		while(true)
		{
			String input=s.nextLine();
			
			String output=c.giveans(input.toLowerCase());
			
			System.out.println(output);
			
			if(c.exit)
			{
				break;
			}
			if(output=="bye")
			{
				break;
				
			}
			
			
			
		}
	}
	public String giveans(String input)
	{
		
		Random rand=new Random();
		
		keywords=new ArrayList<String>();
		
		String tokens[]=input.split("\\s");
		//System.out.println("hhhh");
		
		for(int i=0;i<tokens.length;i++)
		{
		
			if(welcome.containsKey(tokens[i].toLowerCase()))
			{
				return welcome.get(tokens[i]);
				
			}
			else if(farewell.containsKey(tokens[i].toLowerCase()))
			{
				return farewell.get(tokens[i]);
			}
			else if(nouns.containsKey(tokens[i].toLowerCase()))
			{
				return nouns.get(tokens[i]);
				
			}
			
		}
		
		return ("I am sorry. I don't get this.");					
	}

}


/**
--------output---------
which loan is there
Which loan?? Housing ,Personal,Educational.
personal
Which bank would you prefer, SBI, IDBI, Kotak Mahindra, HSBC? i suggest HSBC for Personal loans.
hsbc
HSBC offers 12% interest
which shares
Which company Shares Tata,SBI,Reliance?
tata
Tata shares price is 128.20 INR
bye
bye
**/
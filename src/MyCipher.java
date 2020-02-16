import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class MyCipher 
{
	public static final String alp = "abcdefghijklmnopqrstuvwxyz";
	private static String PlainText = "";
	private static int key1 ;
	private static int key2 ;

	/*
	 * runs the console from the main method
	 * asks for user input
	 * based on that it runs either the encyption or decryption method
	 * */
	 public static void main(String[] args) throws IOException 
	 {
		 
		 System.out.print("Enter 'encrypt' to perofrm encription or 'decrypt' to perform decription:      ");
    	 BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
    	 String input = ip.readLine();
    	 
		 if (input.equals("encrypt")) 
	     {
			 //************* PlainText *************
	    	 System.out.print("Enter The PlainText:      ");
	    	 BufferedReader pt = new BufferedReader(new InputStreamReader(System.in));
	    	 PlainText = pt.readLine();
	    	 
	    	 //**************** first key ******************
		     BufferedReader k1 = new BufferedReader(new InputStreamReader(System.in));
		     System.out.print("Enter The first key as int:      ");
		     key1 = Integer.parseInt(k1.readLine());
		     
		     //**************** second key ******************
		     BufferedReader k2 = new BufferedReader(new InputStreamReader(System.in));
		     System.out.print("Enter The second key as int:      ");
		     key2 = Integer.parseInt(k2.readLine());
		     
		     System.out.println("Your Plain text is: " + PlainText);
		     String enc = encrypt(PlainText,key1,key2);
		     System.out.println("Decrypted: " + enc);
	     } else if(input.equals("decrypt")) 
	     {
			 //************* CipherText *************
	    	 System.out.print("Enter The cipherText:      ");
	    	 BufferedReader ct = new BufferedReader(new InputStreamReader(System.in));
	    	 String Ciphertext = ct.readLine();
	    	 
	    	 //**************** first key ******************
		     BufferedReader k1 = new BufferedReader(new InputStreamReader(System.in));
		     System.out.print("Enter The first key as int:      ");
		     key1 = Integer.parseInt(k1.readLine());
		     
		     //**************** second key ******************
		     BufferedReader k2 = new BufferedReader(new InputStreamReader(System.in));
		     System.out.print("Enter The second key as int:      ");
		     key2 = Integer.parseInt(k2.readLine());
	    	 
	    	 String dec = decrypt(Ciphertext,key1,key2);
	    	 System.out.println("Enecrypted: " + dec);
	    	 
	     }else 
	     {
	    	 System.out.print("Spelled wrong please compile and try again:      ");
	    	 //break;
	     }
		 
	 }
	   /*
	    * encyption method takes input a PlainText
	    * first key and second key
	    * 
	    * */
	   public static String encrypt(String input,int FK,int SK) 
	   {
		   // convert all the input string to upper case even if the input was still in upper case  
		   input = input.toUpperCase();
	       String cipher = "";
	       
	       //third key
	       int key3 = 0;
	       
	       for (int i = 0; i < input.length(); i++) 
	       {
	    	   //OFFSET
	           char get = input.charAt(i);
	           if (Character.isLetter(get)) 
	           {
	               // ax + b % 26
	               get = (char) ((FK * (int)(get + 'A') + SK + key3 ) % 26 + 'A');
	               key3 = key3 + 2;
	           } 
	           cipher +=get;
	       }
	       
	       
	       StringBuffer sb = new StringBuffer(cipher);
	       cipher = sb.reverse().toString();
	       
	       return cipher;
	   }
	   
	   /*
	    * decrypt takes input as CipherText 
	    * first key and second key
	    * which also gets the inverse number from 0 to 26 that using the first key
	    * */
	   public static String decrypt(String input,int FK,int SK) 
	   {
	       String PlainText = "";
	       int x = 0;
	       int inverse = 0;
	       int key3 = 0;
	       
	       // find 1 by using modular inverse
	       // 17 * IN mod 26 == 1
	       // IN is 0 - infinity
	       // if total == 1, then IN is the inverse modular
	       // *** Transposition ***
	       StringBuffer sb = new StringBuffer(input);
	       input = sb.reverse().toString();
	       
	       while(true)
	       {
	         inverse = FK * x % 26;
	            if(inverse == 1)
	               break;
	         x++;
	       }
	       
	       for (int i = 0; i < input.length(); i++) 
	       {
	           char get = input.charAt(i);
	           if (Character.isLetter(get)) 
	           {
	               // IN *(x- b -c) mod 26
	               get = (char)(x * ((get + 'A') - SK - key3 ) % 26 + 'A');
	               key3 = key3 + 2;
	           }
	           PlainText +=get;
	       }
	       return PlainText;
	   }
}
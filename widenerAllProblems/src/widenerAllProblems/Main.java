package dSchwartzWidenerProbsFoRealTisTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean again = true;
		while (again) {
			Scanner reader = new Scanner(System.in); 

			System.out.println("Enter 1 for problem 1, 2 for problem 2, 3 for problem 3...");
			int whichOne = reader.nextInt();
			
			if (whichOne == 1) {
				int year = reader.nextInt();
				p1(year);
			} else if (whichOne == 2) {
				int num = reader.nextInt();
				p2(num);
			} else if (whichOne == 3) {
//				System.out.println("Please enter your input as the signal first and then a space and then the 4 digits together without a space ");
////				System.out.println("For instance '1 6254'");
//				String input = reader.next();
////				System.out.println(input);
////		        String[] words = line.split(" ");
//				String inp2 = reader.nextLine();
////				System.out.println(inp2.substring(1, 5));
//				p3(inp2.substring(0, 1), inp2.substring(1, 5));
				p3();
			} else if (whichOne == 4) {
				p4();
			} else if (whichOne == 5) {
				p5();
			} else {
				System.exit(0);
			}
			
			
		}
		again = false;
	}
	
	public static void p1(int year) {
		if (year < 1582) System.out.println("Not a Leap Year");
		if ((year & 3) == 0 && ((year % 25) != 0 || (year & 15) == 0)) System.out.println("Leap Year"); else System.out.println("Not a Leap Year");
	}
	
	public static void p2(int num) {
		String res = "";
		for (int i = 1; i <= num; i++) {
		int c = 0;	
			for (int j = 1; j < i; j++) {
				if (i % j == 0) c += j;
			}
			if (c == i) res += c + ", ";
		}
		System.out.println(res.substring(0, res.length() - 2));
	}
//	public static void p3(String ser, String code) {
//        if (Integer.parseInt(ser) == 1) System.out.println((((Integer.parseInt(code.substring(2, 3))) + 7) % 10) + "" + (((Integer.parseInt(code.substring(3, 4))) + 7) % 10) + "" + (((Integer.parseInt(code.substring(0, 1))) + 7) % 10)     + "" + (((Integer.parseInt(code.substring(1, 2))) + 7) % 10));
//        if (Integer.parseInt(ser) == 2) System.out.println(Math.abs(((Integer.parseInt(code.substring(1, 2))) - 7) % 10) + "" + Math.abs(((Integer.parseInt(code.substring(3, 4))) - 7) % 10) + "" + Math.abs(((Integer.parseInt(code.substring(0, 1))) - 7) % 10) + "" + Math.abs(((Integer.parseInt(code.substring(2, 3))) - 7) % 10));
// }
	public static void p3() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the text below as the 1 or 2 than a space and then the 4 digits: ");
        String line = input.nextLine();
        String[] words = line.split(" ");
        if (words[0].equals("1")) System.out.println((((Integer.parseInt(words[1].substring(2, 3))) + 7) % 10) + "" + (((Integer.parseInt(words[1].substring(3, 4))) + 7) % 10) + "" + (((Integer.parseInt(words[1].substring(0, 1))) + 7) % 10)     + "" + (((Integer.parseInt(words[1].substring(1, 2))) + 7) % 10));
        if (words[0].equals("2")) System.out.println(Math.floorMod(((Integer.parseInt(words[1].substring(1, 2))) - 7),10) + "" + Math.floorMod(((Integer.parseInt(words[1].substring(3, 4))) - 7),10) + "" + Math.floorMod(((Integer.parseInt(words[1].substring(0, 1))) - 7),10) + "" + Math.floorMod(((Integer.parseInt(words[1].substring(2, 3))) - 7),10));
 }
	
	
	
	
	
	public static int simp(int num, int den) {
        if(den == 0) return num; else return simp(den, num % den);
    }
   
    public static void p4() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the text below in one line: ");
        String line = input.nextLine();
        String[] words = line.split(" ");
        int n = 0, d = 1;
        
        for (int i = 0; i < words.length - 2; i += 2) {
     	   d*=Integer.parseInt(words[i+1]);
        }
        
        for (int j = 0; j < words.length - 2; j += 2) {
     	   n+=((Integer.parseInt(words[j]) * (d / Integer.parseInt(words[j+1]))));
        }
        

		int simplDiv = simp(n, d);

        d = d / simplDiv;
        n = n / simplDiv;
        
        String str = (n/d) + " " + (n - ((n/d) * d)) + "/" + d;
        System.out.println(str);
    }
    
    public static void p5() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
            System.out.println("Please enter the text below in one line: ");
            String line = input.nextLine();
            List<String> myList = new ArrayList<String>(Arrays.asList(line.split(" ")));

            // Step 1
            System.out.println("Step 1: Input Scores: " + myList.toString().substring(1, myList.toString().length() - 1).replaceAll("," , ""));

            // Step 2
            myList.remove(rand.nextInt(myList.size()-1));
            myList.remove(rand.nextInt(myList.size()-1));
            myList.remove(rand.nextInt(myList.size()-1));
            System.out.println("Step 2: Nine random selected scores: " + myList.toString().substring(1, myList.toString().length() - 1).replaceAll("," , ""));
            
            // Step 3
            String min = myList.get(0);
            String max = myList.get(0);
	        for(int i = 0; i < myList.size(); i++) {
	           String num = myList.get(i);
	           if(Integer.parseInt(num) < Integer.parseInt(min)) min = num;
	           if(Integer.parseInt(num) > Integer.parseInt(max)) max = num;
	        }    
	        myList.remove(myList.indexOf(min));
	        myList.remove(myList.indexOf(max));
	        System.out.println("Step 3: The remaining seven scores: " + myList.toString().substring(1, myList.toString().length() - 1).replaceAll("," , ""));
	         
	        // Step 4
	        double sum = 0;
	        for(int i = 0; i < myList.size(); i++) sum += Integer.parseInt(myList.get(i));
	        System.out.println("Step 4: The final score is: " + (sum / 7));
	    }
	
}
package Assignment2;
import java.util.*;

public class StringAssignmentApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringUtility util = new StringUtility();
		String input;
		int choice;
		
		System.out.println("Enter a string: ");
		input = sc.nextLine();
		do {
			System.out.println("1. Count Vowels");
			System.out.println("2. Count constants");
			System.out.println("3. Check Palindrome");
			System.out.println("4. Reverse String");
			System.out.println("5. Convert to Uppercase");
			System.out.println("6. Convert to Lowercase");
			System.out.println("7. Replace a word");
			System.out.println("8. Exit");
			System.out.println("Enter your choice: ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			
			case 1:
				System.out.println("Vowels: " + util.countVowels(input));
				break;
			case 2:
				System.out.println("Constants: " + util.countConstants(input));
				break;
			case 3:
				if(util.isPalindrome(input)) {
				System.out.println("The String is Palindrome ");
				}else {
					System.out.println("The String is NOT Palindrome");
				}
				break;
			case 4:
				System.out.println("Reversed: " + util.reverseString(input));
				break;
			case 5:
				System.out.println("Uppercase: " + util.toUpperCase(input));
				break;
			case 6:
				System.out.println("Lowercase: " + util.toLowerCase(input));
				break;
			case 7:
				System.out.println("Enter a word to replace: ");
				String oldWord = sc.nextLine();
				
				System.out.println("Enter new word: ");
				String newWord = sc.nextLine();
				
				input = util.replaceWord(input, oldWord, newWord);
				System.out.println("Updated String: "+input);
				break;
				
			case 8:
				System.out.println("Exiting. Thankyou...");
				break;
				
			default:
				System.out.println("Invalid choice!");
				
			}
		}
		while (choice!=8);
	}

}

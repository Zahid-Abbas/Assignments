package Assignment1;
import java.util.*;

public class Assignment1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do { // this will reload every time after case is completed
		
			System.out.println("1. Print Table of a Number");
			System.out.println("2. Calculate Factorial");
			System.out.println("3. Check Prime Number");
			System.out.println("4. Print Fibonacci Series");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice");
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				System.out.println("Enter a number to print table");
				int tableNumber = sc.nextInt();
				
				for(int i = 1; i<=10; i++) {
					System.out.println(tableNumber+ " x "+ i+ "= " +(tableNumber*i));
				}
				break;
				
			case 2:
				System.out.println("Enter a number to calculate factoria: ");
				int factNum = sc.nextInt();
				int factorial = 1;
				
				for(int i = 1; i <= factNum; i++) {
					factorial = factorial*i;
				}
				System.out.println("Factorial of"+ factNum +" is "+ factorial);
				break;
				
			case 3: 
				System.out.println("Enter number to check it is prime number");
				int num = sc.nextInt();
				boolean isPrime = true;
				if(num<=1) {
					isPrime = false;
				} else {
				for(int i = 2; i<num/2; i++) {
					if(num%i == 0) {
						isPrime = false;
						break;
					}
				  }
				}
				if(isPrime) {
					System.out.println(num + " is a Prime Number");
				} else {
					System.out.println(num + " is not a Prime Number");
				}
				break;
				
			case 4:
				System.out.println("Enter a number for fibonacci series:");
				int fibnum = sc.nextInt();
				
				int a=0, b=1;
				System.out.println("Fibbonacci Series:");
				
				for(int i =1; i <= fibnum; i++) {
					System.out.println(a+ " ");
					int next = a + b;
					a = b;
					b = next;
				}
				System.out.println();
				break;
			
			case 5: 
				System.out.println("Exiting program, THANKYOU 😎");
				break;
				
				default:
					System.out.println("Invalid Choice. Try again.");
			}	
		}
		while (choice !=5);
		
	}
}


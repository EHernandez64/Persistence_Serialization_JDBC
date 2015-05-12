//Enrique Hernandez
//CS 4311
//Exercise 6a
//2/8/2015

import java.util.Scanner;

public class Obsmain {
	public static void main(String args[]) {
		System.out.println("Observable and Persistent Patterns:");
		System.out.println("Please enter a number for the Program: ");
		Scanner cin = new Scanner(System.in);
		Integer n;
		n = cin.nextInt();
		cin.close();
		Supplier s1 = new Supplier("S1");
		Supplier s2 = new Supplier("S2");
		for(int i = 0; i < n; i++){
			new ObsFrame (s1);
			new ObsFrame(s2);
		}

	}

}

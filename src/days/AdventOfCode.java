package days;

import java.io.IOException;
import java.util.*;

import utils.ReadFile;

public class AdventOfCode {
	
    private final static DayThree day3 = new DayThree();


	public static void main(String[] args) throws IOException {
		

		
		Scanner kbd = new Scanner(System.in);
		
		int day = 0;
		
		while(day != 99) {
			System.out.println("\nWhat Day? (99 to exit)");
			day = kbd.nextInt();
			
			if(day == 1) {
				DayOne day1 = new DayOne();
				day1.DayOne();
			}
			else if (day == 2) {
				DayTwo.DayTwo();
			}
			else if (day == 3) {
				System.out.println("Day 3 Part 1: " + day3.solvePartOne(ReadFile.getInput("/inputs/day3.txt")) );
				System.out.println("Day 3 Part 2: " + day3.solvePartTwo(ReadFile.getInput("/inputs/day3.txt")) );

			}
		}
		kbd.close();
		
	}

}

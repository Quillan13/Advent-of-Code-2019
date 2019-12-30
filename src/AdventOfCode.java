import java.io.IOException;
import java.util.*;
import days.*;
import utils.ReadFile;

public class AdventOfCode {
	
    private final static DayThree day3 = new DayThree();
    private final static DayFour day4 = new DayFour();
    private final static DayFive day5 = new DayFive();
    private final static DaySix day6 = new DaySix();
    private final static DaySeven day7 = new DaySeven();
    private final static DayEight day8 = new DayEight();
    private final static DayNine day9 = new DayNine();
    private final static DayThirteen day13 = new DayThirteen();
    private final static DayFourteen day14 = new DayFourteen();



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
			else if (day == 4) {
				System.out.println("Day 4 Part 1: " + day4.solvePartOne(ReadFile.getInput("/inputs/day4.txt")) );
				System.out.println("Day 4 Part 2: " + day4.solvePartTwo(ReadFile.getInput("/inputs/day4.txt")) );
			}
			else if (day == 5) {
				System.out.println("Day 5 Part 1: " + day5.solvePartOne(ReadFile.getInput("/inputs/day5.txt")) );
				System.out.println("Day 5 Part 2: " + day5.solvePartTwo(ReadFile.getInput("/inputs/day5.txt")) );
			}
			else if (day == 6) {
				System.out.println("Day 6 Part 1: " + day6.solvePartOne(ReadFile.getInput("/inputs/day6.txt")) );
				System.out.println("Day 6 Part 2: " + day6.solvePartTwo(ReadFile.getInput("/inputs/day6.txt")) );
			}
			else if (day == 7) {
				System.out.println("Day 7 Part 1: " + day7.solvePartOne(ReadFile.getInput("/inputs/day7.txt")) );
				System.out.println("Day 7 Part 2: " + day7.solvePartTwo(ReadFile.getInput("/inputs/day7.txt")) );
			}
			else if (day == 8) {
				System.out.println("Day 8 Part 1: " + day8.solvePartOne(ReadFile.getInput("/inputs/day8.txt")) );
				System.out.println("Day 8 Part 2: \n" + day8.solvePartTwo(ReadFile.getInput("/inputs/day8.txt")) );
			}
			else if (day == 9) {
				System.out.println("Day 9 Part 1: " + day9.solvePartOne(ReadFile.getInput("/inputs/day9.txt")) );
				System.out.println("Day 9 Part 2: " + day9.solvePartTwo(ReadFile.getInput("/inputs/day9.txt")) );
			}
			else if (day == 13) {
				System.out.println("Day 13 Part 1: " + day13.solvePartOne(ReadFile.getInput("/inputs/day13.txt")) );
				System.out.println("Day 13 Part 2: " + day13.solvePartTwo(ReadFile.getInput("/inputs/day13.txt")) );
			}
			else if (day == 14) {
				System.out.println("Day 14 Part 1: " + day14.solvePartOne(ReadFile.getInput("/inputs/day14.txt")) );
				System.out.println("Day 14 Part 2: " + day14.solvePartTwo(ReadFile.getInput("/inputs/day14.txt")) );
			}
		}
		kbd.close();
		
	}

}

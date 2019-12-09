package days;

import java.io.IOException;
import java.util.*;

public class AdventOfCode {

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
				DayTwo day2 = new DayTwo();
				day2.DayTwo();
			}
		}
		kbd.close();
		
	}

}

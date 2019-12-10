package days;

import java.util.stream.*;
import java.io.IOException;
import java.nio.file.*;

public class DayTwo {
	
	public static void DayTwo() {
	Integer[] optcodes = null;
	
	//parse codes file separated by comma
	try (Stream<String> stream = Files.lines(Paths.get("src/inputs/day2.txt"))) {
		String[] temp = stream.toArray(String[]::new)[0].split(",");
		optcodes = new Integer[temp.length];
		
		//set codes as optcodes array
		for(int i = 0; i < temp.length; ++i) {
			optcodes[i] = Integer.parseInt(temp[i]);
		}
		
		//change optcodes due to directions
		optcodes[1] = 12;
		optcodes[2] = 2;
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	boolean done = false;
	
	//run through optcodes
	for(int i = 0; i < optcodes.length; i += 4) {
		switch(optcodes[i]) {
		case 1:
			optcodes[optcodes[i + 3]] = optcodes[optcodes[i + 1]] + optcodes[optcodes[i + 2]];
			break;
		case 2:
			optcodes[optcodes[i + 3]] = optcodes[optcodes[i + 1]] * optcodes[optcodes[i + 2]];
			break;
		case 99:
			done = true;
			break;
		}
		
		if(done) {
			break;
		}
	}
	
	System.out.println("\nDay 2 Part 1: " + optcodes[0]);
	part2();
	}
	
	private static void part2() {
		
		//what we're looking for
		final int TARGET = 19690720;
		
		
		Integer[] codes = null;
		
		try (Stream<String> stream = Files.lines(Paths.get("src/inputs/day2.txt"))) {
			String[] temp = stream.toArray(String[]::new)[0].split(",");
			codes = new Integer[temp.length];

			for(int i = 0; i < temp.length; ++i) {
				codes[i] = Integer.parseInt(temp[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		boolean found = false;
		for(int a = 0; a <= 99; ++a) {
			for(int b = 0; b <= 99; ++b) {
				Integer[] optcodes = new Integer[codes.length];
				System.arraycopy(codes, 0, optcodes, 0, codes.length);
				
				optcodes[1] = a;
				optcodes[2] = b;
				
				boolean done = false;
				for(int i = 0; i < optcodes.length; i += 4) {
					switch(optcodes[i]) {
					case 1:
						optcodes[optcodes[i + 3]] = optcodes[optcodes[i + 1]] + optcodes[optcodes[i + 2]];
						break;
					case 2:
						optcodes[optcodes[i + 3]] = optcodes[optcodes[i + 1]] * optcodes[optcodes[i + 2]];
						break;
					case 99:
						done = true;
						break;
					}
					
					if(done) {
						if(optcodes[0] == TARGET) {
							System.out.println("Day 2 Part 2: " + a + b);
							found = true;
						}
						break;
					}
				}
				
				if(found) {
					break;
				}
			}
		}
	}
}


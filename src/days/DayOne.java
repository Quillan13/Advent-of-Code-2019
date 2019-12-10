package days;

import java.io.IOException;
import java.util.*;


import utils.ReadFile;

public class DayOne {
	
	public void DayOne() throws IOException {
		
		//input
		ReadFile rf = new ReadFile();
		List<String> input = rf.readFile("src/inputs/day1.txt");
	
		System.out.println("\nDay 1 Part 1: " + this.part1(input));
		System.out.println("Day 2 Part 2: " + this.part2(input));
	}

	//part 1 solution
	public int part1(List<String> input) {
		return input.stream().map(Integer::parseInt).map(this::calcFuel).reduce(0, Integer::sum);
	}
	
	//part 2 solution
	public int part2(List<String> input) {
		return input.stream().map(Integer::parseInt).map(this::calcExtraFuel).reduce(0, Integer::sum);
	}
	
	//calculate fuel for masses
	private int calcFuel(Integer mass) {
		return mass / 3 - 2;
		}
	
	//calculate mass of fuel
	private int calcExtraFuel(Integer mass) {
        int fuel = calcFuel(mass);
        if (fuel > 0) return fuel + calcExtraFuel(fuel);
        else return 0;
    }
}
		



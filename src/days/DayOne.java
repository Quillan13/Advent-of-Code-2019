package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayOne {
	
	public void DayOne() throws IOException {
		//input
		List<String> input = new ArrayList<>();
		BufferedReader br = null;
		
		try {

			br = new BufferedReader(new FileReader("src/inputs/day1.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				input.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		
		System.out.println("\nDay 1 Part 1: " + this.part1(input));
		System.out.println("Day 2 Part 2: " + this.part2(input));
	}

	
//	List<String> input = Arrays.asList(
//			"119965",
//			"69635",
//			"134375",
//			"71834",
//			"124313",
//			"109114",
//			"80935",
//			"146441",
//			"120287",
//			"85102",
//			"148451",
//			"69703",
//			"143836",
//			"75280",
//			"83963",
//			"108849",
//			"133032",
//			"109359",
//			"78119",
//			"104402",
//			"89156",
//			"116946",
//			"132008",
//			"131627",
//			"124358",
//			"56060",
//			"141515",
//			"75639",
//			"146945",
//			"95026",
//			"99256",
//			"57751",
//			"148607",
//			"100505",
//			"65002",
//			"78485",
//			"84473",
//			"112331",
//			"82177",
//			"111298",
//			"131964",
//			"125753",
//			"63970",
//			"77100",
//			"90922",
//			"119326",
//			"51747",
//			"104086",
//			"141344",
//			"54409",
//			"69642",
//			"70193",
//			"109730",
//			"73782",
//			"92049",
//			"90532",
//			"147093",
//			"62719",
//			"79829",
//			"142640",
//			"85242",
//			"128001",
//			"71403",
//			"75365",
//			"90146",
//			"147194",
//			"76903",
//			"68895",
//			"56817",
//			"142352",
//			"77843",
//			"64082",
//			"106953",
//			"115590",
//			"87224",
//			"58146",
//			"134018",
//			"127111",
//			"51996",
//			"134433",
//			"148768",
//			"103906",
//			"52848",
//			"108577",
//			"77646",
//			"95930",
//			"67333",
//			"98697",
//			"55870",
//			"78927",
//			"148519",
//			"68724",
//			"93076",
//			"73736",
//			"140291",
//			"121184",
//			"111768",
//			"71920",
//			"104822",
//			"87534"
//			);

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
		



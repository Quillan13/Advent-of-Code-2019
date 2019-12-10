package days;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collectors;

import utils.Node;
import utils.Path;
import utils.ReadFile;

public class DayThree {
	
	private static String[] input = ReadFile.getString("src/inputs/day3.txt").split("\n");
	
	public static void DayThree() {
     String[] dir1 = input[0].split(",");
     String[] dir2 = input[1].split(",");

     System.out.println("Day 1 Part 1: " + part1(dir1, dir2));
     part2();
	}

	 private static int part1(String[] dir1, String[] dir2) {
	     Set<Point> line1 = getLine(dir1);
	     Set<Point> line2 = getLine(dir2);
	
	     int min = Integer.MAX_VALUE;
	     Set<Point> matching = line1.stream().filter(line2::contains).collect(Collectors.toSet());
	     for(Point p : matching)
	         min = Math.min(min, Math.abs(p.x) + Math.abs(p.y));
	
	     return min;
	 }

	 
	 private static Set<Point> getLine(String[] directions) {
	     int x = 0, y = 0;
	     Set<Point> line = new HashSet<>();
	     for(String s : directions) {
	         for(int i = 0; i < Integer.valueOf(s.substring(1)); i++) {
	             switch(s.charAt(0)) {
	                 case 'U' : line.add(new Point(x, ++y)); break;
	                 case 'D' : line.add(new Point(x, --y)); break;
	                 case 'L' : line.add(new Point(--x, y)); break;
	                 case 'R' : line.add(new Point(++x, y)); break;
	             }
	         }
	     }
	     return line;
	 }
	 
	 private static void part2() {
		
		 //setup nodes and path functions in utils
		Path path1 = new Path();
		Path path2 = new Path();
		
		//split the optcodes
		path1.buildPath(input[0].split(","));
		path2.buildPath(input[1].split(","));
		
		List<Node> inters = path1.findIntersections(path2);
		List<Integer> dist = inters.stream().map(node -> node.length).collect(Collectors.toList());
		dist.sort((a,b) -> { return a-b; });
		
		//Output Part 2
		System.out.println("Day 2 Part 2: "+ dist.get(0));
			
	 }
	 
}


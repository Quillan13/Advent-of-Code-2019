package days;

import utils.Intcode;

public class DayFive {
    public String solvePartOne(String input) {
        return solve(input, new int[] { 1 });
    }

    public String solvePartTwo(String input) {
        return solve(input, new int[] { 5 });
    }

    private String solve(String input, int[] programInput) {
        Intcode program = Intcode.parseIntcodeCode(input);
        int[] output = program.run(programInput);
        return String.valueOf(output[output.length - 1]);
    }
}
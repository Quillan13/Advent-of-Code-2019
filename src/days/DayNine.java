package days;

import java.util.stream.Collectors;

import utils.IntcodeComputer;
import static utils.IntcodeComputer.END_OF_OUTPUT;

public class DayNine {
    public String solvePartOne(String input) {
        return solve(input, 1L);
    }

    public String solvePartTwo(String input) {
        return solve(input, 2L);
    }

    private String solve(String inputProgram, long inputData) {
        IntcodeComputer computer = IntcodeComputer.parseIntcodeCode(inputProgram);

        computer.start();
        computer.write(inputData);

        try {
            computer.join();
            return computer.stream()
                    .filter(l -> l != END_OF_OUTPUT)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }
}
package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day7Test {
    private Day7 day = new Day7();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day7ex.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));
    }
    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day7ex2.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day7.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day7.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
}
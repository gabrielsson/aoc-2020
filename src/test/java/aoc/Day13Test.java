package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day13Test {
    private Day13 day = new Day13();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day13ex.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day13ex.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day13.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day13.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
}
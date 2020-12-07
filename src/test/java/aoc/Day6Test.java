package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day6Test {
    private Day6 day = new Day6();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day6ex.txt");
        Assertions.assertEquals(11, day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day6.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day6.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
}
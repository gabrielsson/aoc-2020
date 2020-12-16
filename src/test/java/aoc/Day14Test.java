package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day14Test {
    private Day14 day = new Day14();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day14ex.txt");
        Assertions.assertEquals(165L, day.part1(input.getListOfRows()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day14ex2.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day14.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day14.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
}
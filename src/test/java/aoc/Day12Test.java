package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day12Test {
    private Day12 day = new Day12();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day12ex.txt");
        Assertions.assertEquals(25, day.part1(input.getListOfRows()));
    }
    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day12ex.txt");
        Assertions.assertEquals(286, day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day12.txt");
        Assertions.assertEquals(1496, day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day12.txt");
        Assertions.assertEquals(63843, day.part2(input.getListOfRows()));
    }
}
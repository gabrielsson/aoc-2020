package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day8Test {
    private Day8 day = new Day8();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day8ex.txt");
        Assertions.assertEquals(5L, day.part1(input.getListOfRows()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day8ex.txt");
        Assertions.assertEquals(8L, day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day8.txt");
        Assertions.assertEquals(1394L, day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day8.txt");
        Assertions.assertEquals(1626L, day.part2(input.getListOfRows()));
    }
}
package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day10Test {
    private Day10 day = new Day10();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day10ex.txt");
        Assertions.assertEquals(220, day.part1(input.getListOfIntegers()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day10ex.txt");
        Assertions.assertEquals(19208L, day.part2(input.getListOfIntegers()));
    }


    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day10.txt");
        Assertions.assertEquals(2176, day.part1(input.getListOfIntegers()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day10.txt");
        Assertions.assertEquals(18512297918464L, day.part2(input.getListOfIntegers()));
    }
}
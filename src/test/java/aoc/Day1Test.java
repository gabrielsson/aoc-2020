package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {
    private Day1 day = new Day1();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day1example.txt");
        Assertions.assertEquals(514579, day.part1(input.getListOfIntegers()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day1.txt");
        Assertions.assertEquals(357504, day.part1(input.getListOfIntegers()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day1.txt");
        Assertions.assertEquals(12747392, day.part2(input.getListOfIntegers()));
    }
}
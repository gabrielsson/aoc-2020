package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2Test {
    private Day2 day = new Day2();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day2ex.txt");
        Assertions.assertEquals(1l, day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day2.txt");
        Assertions.assertEquals(506l, day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day2.txt");
        Assertions.assertEquals(443l, day.part2(input.getListOfRows()));
    }
}
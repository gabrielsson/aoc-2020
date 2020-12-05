package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day5Test {
    private Day5 day = new Day5();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day5ex.txt");
        Assertions.assertEquals(820, day.part1(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day5.txt");
        Assertions.assertEquals(933, day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day5.txt");
        Assertions.assertEquals(711, day.part2(input.getListOfRows()));
    }
}
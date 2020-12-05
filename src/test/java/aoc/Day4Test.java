package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Test {
    private Day4 day = new Day4();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day4ex.txt");
        Assertions.assertEquals(2l, day.part1(input.getListOfRows()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day4valid.txt");
        Assertions.assertEquals(4l, day.part2(input.getListOfRows()));
    }
    @Test
    public void part2examplein() {
        PuzzleInput input = new PuzzleInput("day4invalid.txt");
        Assertions.assertEquals(0l, day.part2(input.getListOfRows()));
    }
    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day4.txt");
        Assertions.assertEquals(256l, day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day4.txt");
        Assertions.assertEquals(198l, day.part2(input.getListOfRows()));
    }
}
package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day16Test {
    private Day16 day = new Day16();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day16ex.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day16ex.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day16.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day16.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
}
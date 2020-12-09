package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day9Test {
    private Day9 day = new Day9();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day9ex.txt");
        Assertions.assertEquals(127L, day.part1(input.getListOfLongs(), 5));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day9ex.txt");
        Assertions.assertEquals(62L, day.part2(input.getListOfLongs(), 127L));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day9.txt");
        Assertions.assertEquals(69316178L, day.part1(input.getListOfLongs(), 25));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day9.txt");
        Assertions.assertEquals(9351526L, day.part2(input.getListOfLongs(), (Long) day.part1(input.getListOfLongs(), 25)));
    }
}
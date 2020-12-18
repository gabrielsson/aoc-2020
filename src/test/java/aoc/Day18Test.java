package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day18Test {
    private Day18 day = new Day18();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day18ex.txt");
        Assertions.assertEquals(122L, day.part1(input.getListOfRows()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day18ex.txt");
        Assertions.assertEquals(282L, day.part2(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day18.txt");
        Assertions.assertEquals(510009915468L, day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day18.txt");
        Assertions.assertEquals(321176691637769L, day.part2(input.getListOfRows()));
    }
}
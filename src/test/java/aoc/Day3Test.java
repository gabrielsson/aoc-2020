package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {
    private Day3 day = new Day3();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day3ex.txt");
        Assertions.assertEquals(7l, day.part1(input.getMapXy()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day3.txt");
        Assertions.assertEquals(151l, day.part1(input.getMapXy()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day3.txt");
        Assertions.assertEquals(7540141059l, day.part2(input.getMapXy()));
    }
}
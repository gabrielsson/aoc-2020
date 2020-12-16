package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day15Test {
    private Day15 day = new Day15();

    @Test
    public void part1example() {
        Assertions.assertEquals(436, day.part1(Arrays.asList(0,3,6), 2020));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day.txt");
        Assertions.assertEquals("", day.part1(Arrays.asList(0,14,1,3,7,9), 2020));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day.txt");
        Assertions.assertEquals("", day.part2(Arrays.asList(0,14,1,3,7,9), 30000000));
    }
}
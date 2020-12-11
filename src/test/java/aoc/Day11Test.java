package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day11Test {
    private Day11 day = new Day11();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day11ex.txt");
        Assertions.assertEquals(37, day.part1(input.getMapXy()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day11ex.txt");
        Assertions.assertEquals(26, day.part2(input.getMapXy()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day11.txt");
        Assertions.assertEquals(2494, day.part1(input.getMapXy()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day11.txt");
        Assertions.assertEquals(2306, day.part2(input.getMapXy()));
    }
}
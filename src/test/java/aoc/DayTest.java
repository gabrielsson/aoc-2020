package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayTest {
    private Day day;

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day.txt");
        Assertions.assertEquals("", day.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day.txt");
        Assertions.assertEquals("", day.part2(input.getListOfRows()));
    }
}
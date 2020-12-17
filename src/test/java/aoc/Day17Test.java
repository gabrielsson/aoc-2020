package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point3i;
import java.util.HashMap;
import java.util.Map;

public class Day17Test {
    private Day17 day = new Day17();

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day17ex.txt");
        Assertions.assertEquals(112L, day.part1(input.getMapXy()));
    }

    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day17ex.txt");
        Assertions.assertEquals(848L, day.part2(input.getMapXy()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day17.txt");
        Assertions.assertEquals(348L, day.part1(input.getMapXy()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day17.txt");
        Assertions.assertEquals(2236L, day.part2(input.getMapXy()));
    }
}
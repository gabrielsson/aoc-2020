package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Day15 {

    public Object part1(List<Integer> listOfRows, int turns) {
        Map<Integer, Integer> numberTurns = new HashMap<>();
        IntStream.range(0, listOfRows.size()).forEach(turn -> numberTurns.put(listOfRows.get(turn), turn));
        Integer guess = 0;
        for (int turn = numberTurns.size(); turn + 1 < turns; turn++) {
            var lastTurnTheNumberAppeared = numberTurns.getOrDefault(guess, 0);
            numberTurns.put(guess, turn);
            guess = lastTurnTheNumberAppeared;
        }
        return guess;
    }

    public Object part2(List<Integer> listOfRows, int turns) {
        return part1(listOfRows, turns);

    }

}

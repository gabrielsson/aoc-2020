package aoc;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day13 {
    public Object part1(List<String> listOfRows) {
        int timestamp = Integer.parseInt(listOfRows.get(0));

        var busEntry = Arrays.stream(listOfRows.get(1).split(","))
            .filter(s -> !"x".equals(s))
            .map(Integer::parseInt)
            .collect(Collectors.toMap(
                i -> i,
                i -> i - (timestamp % i))
            )
            .entrySet().stream()
            .min(Comparator.comparing(Map.Entry::getValue))
            .get();

        return busEntry.getKey() * busEntry.getValue();

    }

    public Object part2(List<String> listOfRows) {

        String[] split = listOfRows.get(1).split(",");

        List<Map.Entry<Integer, Integer>> buses = IntStream.range(0, split.length)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toMap(
                i -> i,
                i -> split[i])
            ).entrySet().stream()
            .filter(e -> !"x".equals(e.getValue()))
            .map(entry -> new AbstractMap.SimpleEntry<Integer, Integer>(entry.getKey(),
                Integer.valueOf(entry.getValue())))
            .sorted(Comparator.comparing(Map.Entry::getValue))
            .collect(Collectors.toList());

        long time = 0L;
        long multiplier = 1L;
        for (var bus : buses) {
            boolean found = false;
            while (!found) {
                if ((time + bus.getKey()) % bus.getValue() == 0) {
                    multiplier *= bus.getValue();
                    found = true;
                } else {
                    time += multiplier;
                }
            }
        }

        return time;
    }

    public Object part2WolframAlfa(List<String> listOfRows) {

        String[] split = listOfRows.get(1).split(",");

        List<Integer> numbers = new ArrayList<>();
        List<Integer> remainders = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            if (!"x".equals(split[i])) {
                numbers.add(Integer.valueOf(split[i]));
                remainders.add(i);
            }
        }

        long[] rem = remainders.stream().mapToLong(Integer::intValue).toArray();
        long[] bus = numbers.stream().mapToLong(Integer::intValue).toArray();

        System.out.println("Copy paste into wolframalfa");
        for (int i = 0; i < rem.length; i++) {
            System.out.println(String.format("(t + %s) mod %s = 0;", rem[i], bus[i]));
        }

        var l = 725850285300475L;
        System.out.println();
        return l;

    }
}

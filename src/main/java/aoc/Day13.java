package aoc;

import lombok.Builder;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day13 {
    public Object part1(List<String> listOfRows) {
        int timestamp = Integer.parseInt(listOfRows.get(0));
        var bus = streamBuses(listOfRows.get(1).split(","))
            .min(Comparator.comparing(b -> b.nextBus(timestamp)))
            .get();
        return bus.nextBus(timestamp)* bus.getBusId();
    }

    public Object part2(List<String> listOfRows) {

        AtomicLong time = new AtomicLong(0L);
        AtomicLong multiplier = new AtomicLong(1L);

        streamBuses(listOfRows.get(1).split(","))
            .forEach(bus -> {
                boolean found = false;
                while (!found) {
                    if ((time.get() + bus.getOffset()) % bus.getBusId() == 0) {
                        multiplier.updateAndGet(v -> v * bus.getBusId());
                        found = true;
                    } else {
                        time.addAndGet(multiplier.get());
                    }
                }
            });
        return time.get();
    }

    private Stream<Bus> streamBuses(String[] split) {
        return IntStream.range(0, split.length)
            .mapToObj(i -> Bus.builder()
                .value(split[i])
                .offset(i)
                .build())
            .filter(Bus::isValid);
    }

    @Builder
    public static class Bus {
        String value;
        Integer offset;

        public boolean isValid() {
            return !"x".equals(value);
        }

        public int getOffset() {
            return offset;
        }

        public int getBusId() {
            try {
                return Integer.valueOf(value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextBus(int timestamp) {
            return getBusId() - (timestamp % getBusId());
        }
    }

    public Object part2WolframAlpha(List<String> listOfRows) {

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

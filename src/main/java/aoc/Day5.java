package aoc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day5 {
    public Object part1(List<String> listOfRows) {
        return listOfRows.stream()
            .mapToInt(this::toSeatId)
            .max().getAsInt();
    }

    public Object part2(List<String> listOfRows) {
        return Math.abs(listOfRows.stream()
            .map(this::toSeatId).sorted()
            .reduce(0, this::findNegativeSeatId));
    }

    private Integer findNegativeSeatId(int currentSeat, int nextSeat) {
        if (currentSeat < 0) {
            return currentSeat; // answer is found
        } else if (currentSeat == 0) {
            return nextSeat; // first time
        } else if (nextSeat - currentSeat > 1) {
            return  -nextSeat + 1; // return negative answer to halt reduction
        } else {
            return nextSeat; // always return next
        }
    }

    private int toSeatId(String s) {
        return Integer.parseInt(s
            .replaceAll("[B,R]", "1")
            .replaceAll("[F,L]", "0"), 2);
    }

    //drawings

    private void drawPlaneLayout(List<Integer> collect) {
        for (int i = 0; i < 26; i++) {
            String space = "                                     ";
            System.out.print(space.substring(0, 26 - i));
            System.out.print("/");
            System.out.print(space.substring(0, i));
            System.out.print(space.substring(0, i));

            System.out.println("\\");
        }
        Map<Integer, String> map = collect.stream()
            .collect(Collectors.toMap(ticket -> ticket, this::getSeatNumber));
        for (int i = 0; i < collect.size(); i++) {
            if (i % 8 == 0) {
                System.out.println();

            }
            if (i % 4 == 0) {
                System.out.print("     ");
            }

            System.out.print(map.getOrDefault(i, "\u001B[32m\u001B[41m[   ]\u001B[0m"));

        }

    }

    public String getSeatNumber(int seatId) {
        String s = "[";
        s += seatId < 10 ? "  " + seatId : seatId < 100 ? " " + seatId : seatId;
        s += "]";

        return s;

    }

}

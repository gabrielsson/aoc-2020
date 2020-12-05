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
        List<Integer> collect = listOfRows.stream()
            .map(this::toSeatId).sorted()
            .collect(Collectors.toList());

        for(int i = 1; i < collect.size() -1; i++) {
            if(collect.get(i - 1) +2 == collect.get(i)) {
                return collect.get(i) -1;
            }
        }

        return null;
    }

    private int toSeatId(String s) {
        String replace = s.replace("B", "1")
            .replace("F", "0")
            .replace("L", "0")
            .replace("R", "1");

        return Integer.valueOf(replace, 2);
    }


    //drawings

    private void drawPlaneLayout(List<Integer> collect) {
        for(int i = 0; i < 26; i++) {
            String space = "                                     ";
            System.out.print(space.substring(0, 26-i));
            System.out.print("/");
            System.out.print(space.substring(0,i));
            System.out.print(space.substring(0,i));

            System.out.println("\\");
        }
        Map<Integer, String> map = collect.stream().collect(Collectors.toMap(ticket -> ticket, ticket -> getSeatNumber(ticket)));
        for(int i = 0; i < collect.size(); i++) {
            if (i % 8 == 0) {
                System.out.println();

            }
            if(i % 4 == 0) {
                System.out.print("     ");
            }

            System.out.print(map.getOrDefault(i, "\u001B[32m\u001B[41m[   ]\u001B[0m"));

        }

    }
    public String getSeatNumber(int seatId) {
        String s = "[";
        s += seatId<10? "  " + seatId : seatId < 100? " " + seatId: seatId;
        s += "]";

        return s;

    }




}

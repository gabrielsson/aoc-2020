package aoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day6 {
    public Object part1(List<String> listOfRows) {

        Set<String> letters = new HashSet<>();
        int count = 0;
        for (var row : listOfRows) {

            if (row.trim().isEmpty()) {
                count += letters.size();

                letters.clear();

                continue;
            }
            letters.addAll(Arrays.asList(row.split("")));
        }
        return count;

    }

    public Object part2(List<String> listOfRows) {

        Map<String, Integer> letterGroup = new HashMap<>();
        int count = 0;
        int personsInGroup = 0;
        for (var row : listOfRows) {

            if (!row.trim().isEmpty()) {

                String[] personsLetter = row.split("");
                for(var l: personsLetter) {

                    Integer letterCount = letterGroup.getOrDefault(l, 0);
                    letterCount++;
                    letterGroup.put(l, letterCount);

                }
                personsInGroup++;
            } else {
                for(var e : letterGroup.entrySet()) {
                    if ( e.getValue() == personsInGroup) {
                        count++;
                    }
                }

                letterGroup.clear();
                personsInGroup =0;
                continue;
            }


        }
        return count;


    }

}

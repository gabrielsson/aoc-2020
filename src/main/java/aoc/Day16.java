package aoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.paukov.combinatorics3.PermutationGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day16 {
    public Object part1(List<String> listOfRows) {

        List<Value> list = new ArrayList<>();
        int i = 0;
        for(var s: listOfRows) {
            if(s.isEmpty()) break;
            Matcher keyMatcher = Pattern.compile(".*(?=:)").matcher(s);
            keyMatcher.find();
            String key = keyMatcher.group();
            Matcher numberMatcher = Pattern.compile("\\d+").matcher(s);
            numberMatcher.find();
            int min1 = Integer.parseInt(numberMatcher.group());
            numberMatcher.find();
            int max1 = Integer.parseInt(numberMatcher.group());
            numberMatcher.find();
            int min2 = Integer.parseInt(numberMatcher.group());
            numberMatcher.find();
            int max2 = Integer.parseInt(numberMatcher.group());

            list.add(new Value(key, min1, max1, min2, max2));

            i++;
        }
        i+=5;
        Map<Integer, List<Value>> fits = new HashMap<>();
        long sum = 0;
        for(; i< listOfRows.size(); i++) {
            String s = listOfRows.get(i);
            int[] ints = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).sorted().toArray();

            for(int j : ints) {
                boolean valid = false;
                for(var value : list) {
                    if(value.canHandle(j)) {
                        valid = true;
                        break;
                    }
                }

                if(!valid) {
                    sum+=j;
                }
            }

        }

        return sum;

    }

    public Object part2(List<String> listOfRows) {

        List<Value> rules = new ArrayList<>();
        int i = 0;
        for(var s: listOfRows) {
            if(s.isEmpty()) break;
            Matcher keyMatcher = Pattern.compile(".*(?=:)").matcher(s);
            keyMatcher.find();
            String key = keyMatcher.group();
            Matcher numberMatcher = Pattern.compile("\\d+").matcher(s);
            numberMatcher.find();
            int min1 = Integer.parseInt(numberMatcher.group());
            numberMatcher.find();
            int max1 = Integer.parseInt(numberMatcher.group());
            numberMatcher.find();
            int min2 = Integer.parseInt(numberMatcher.group());
            numberMatcher.find();
            int max2 = Integer.parseInt(numberMatcher.group());

            rules.add(new Value(key, min1, max1, min2, max2));

            i++;
        }
        i+=5;
        List<int[]> validTickets = new ArrayList<>();

        for(; i< listOfRows.size(); i++) {
            String s = listOfRows.get(i);
            int[] ints = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            boolean valid = true;
            for(int j : ints) {
                boolean partValid = false;

                for(var value : rules) {
                    if(value.canHandle(j)) {
                        partValid = true;
                        break;
                    }
                }

                if(!partValid) {
                    valid = false;
                    break;
                }

            }
            if(valid) {
                validTickets.add(ints);
            }

        }

        Map<String, Set<Integer>> keyMap = new HashMap<>();
        for(int index = 0; index < validTickets.get(0).length; index++) {
            int finalIndex = index;
            List<Integer> category = validTickets.stream().map(ints -> ints[finalIndex]).collect(Collectors.toList());
            for(var ticket : validTickets) {
                for(var rule : rules) {
                    if(category.stream().allMatch(rule::canHandle)) {
                        Set<Integer> orDefault = keyMap.getOrDefault(rule.key, new HashSet<>());
                        orDefault.add(index);
                        keyMap.putIfAbsent(rule.key, orDefault);
                    }

                }
            }
        }

        Map<String, Integer> stringIntegerMap = figureOut(keyMap);

        List<Integer> myTicket = Arrays.asList(59, 101, 191, 149, 167, 197, 199, 137, 163, 131, 113, 67, 103, 97, 61, 139, 157, 151, 193, 53);

        return stringIntegerMap.entrySet().stream()
            .filter(stringIntegerEntry -> stringIntegerEntry.getKey().startsWith("departure"))
            .mapToLong(stringIntegerEntry -> myTicket.get(stringIntegerEntry.getValue()))
            .reduce((l, l1) -> l*l1);




    }

    private Map<String, Integer> figureOut(Map<String, Set<Integer>> keyMap) {
        Map<String, Integer> result = new HashMap<>();
        Map.Entry<String, Set<Integer>> stringSetEntry = keyMap.entrySet().stream().filter(e -> e.getValue().size() == 1).findFirst().get();
        String key = stringSetEntry.getKey();
        Integer index = stringSetEntry.getValue().iterator().next();
        result.put(key, index);
        keyMap.remove(key);
        keyMap.values().forEach(integers1 -> integers1.remove(index));

        if(!keyMap.isEmpty()) {
            result.putAll(figureOut(keyMap));
        }

        return result;
    }

    @Data
    @ToString
    @AllArgsConstructor
    public static class Value {
        String key;
        Integer min1;
        Integer max1;
        Integer min2;
        Integer max2;

        boolean canHandle(int i) {
            return (min1 <= i && i <=max1) || (min2 <= i && i <=max2);
        }
    }
}

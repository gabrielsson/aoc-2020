package aoc;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
    public Object part1(List<Integer> listOfRows) {
        int[] ints = getInts(listOfRows);

        int ones = 0;
        int threes = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            int difference = ints[i + 1] - ints[i];
            if (difference == 1) {
                ones++;
            }
            if (difference == 3) {
                threes++;
            }
        }
        return ones * threes;

    }

    private int[] getInts(List<Integer> listOfRows) {
        listOfRows.add(0);
        int max = listOfRows.stream().mapToInt(Integer::intValue).max().getAsInt() + 3;
        listOfRows.add(max);
        return listOfRows.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public long part2(List<Integer> listOfRows) {
        return listOfPossiblePermutations(getInts(listOfRows)).stream()
            .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
            .map(arr -> countCompleteConnections(arr, 0, 0))
            .reduce((v1,v2) -> v1*v2).get();
    }



    private long countCompleteConnections(int[] ints, int index, long result) {
        if (index == ints.length-1) {
            return ++result;
        }

        for (int j = 1; j <= 3 && index + j < ints.length; j++) {
            if (ints[index + j] - ints[index]  <= 3) {
                result = countCompleteConnections(ints, index + j, result);
            }
        }

        return result;
    }

    private List<List<Integer>> listOfPossiblePermutations(int[] ints) {
        List<List<Integer>> listOfPossiblePermutations = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i + 1] - ints[i] < 3) {  //step is small enough to possibly be skipped
                sublist.add(ints[i]);
            } else { // the step is 3 (or more) so this is not a permutation
                sublist.add(ints[i]);
                listOfPossiblePermutations.add(sublist);
                sublist = new ArrayList<>();
            }
        }
        return listOfPossiblePermutations;
    }

}

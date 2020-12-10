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

    public Object part2(List<Integer> listOfRows) {

        int[] ints = getInts(listOfRows);
        List<List<Integer>> listOfPossiblePermutations = listOfPermutableLists(ints);

        long sum = 1;
        for (var sub : listOfPossiblePermutations) {

            long i = 0;
            sum *= countCompleteConnections(sub.toArray(new Integer[sub.size()]), sub.size() - 1, i);
        }

        return sum;

    }



    private long countCompleteConnections(Integer[] ints, int index, long result) {
        if (index == 0) {
            return ++result;
        }
        for (int j = 1; j <= 3 && index - j >= 0; j++) {

            if (ints[index] - ints[index - j] <= 3) {
                result = countCompleteConnections(ints, index - j, result);
            }
        }

        return result;
    }

    private List<List<Integer>> listOfPermutableLists(int[] ints) {
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

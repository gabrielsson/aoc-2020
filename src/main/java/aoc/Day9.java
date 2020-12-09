package aoc;

import java.util.List;
import java.util.OptionalLong;

public class Day9 {
    public Object part1(List<Long> listOfRows, int preamble) {

        Long current=null;


        for(int i = preamble; i<listOfRows.size(); i++) {

            current = listOfRows.get(i);
            List<Long> sublist = listOfRows.subList(i - preamble, i);
            boolean found = false;
            subtask:
            for(int j = 0; j<sublist.size(); j++) {

                for(int k = 0; k<sublist.size(); k++) {
                    Long first = sublist.get(j);
                    Long second = sublist.get(k);
                    if(first + second == current) {
                        found = true;
                        break subtask;
                    }
                }
            }
            if(!found) break;
        }

        return current;

    }

    public Object part2(List<Long> listOfRows, final Long number) {
        int startIndex = 0;
        int endIndex = 0;



        task:
        for(int i = 0; i<listOfRows.size(); i++) {
            Long sum = number;
            startIndex=i;
            for(int j = i; j<listOfRows.size(); j++) {

                sum -= listOfRows.get(j);
                if(sum == 0) {
                    endIndex = j;
                    break task;
                } else if(sum < 0) {
                    break;
                }
            }
        }

        Long min = listOfRows.subList(startIndex, endIndex).stream().mapToLong(Long::longValue).min().getAsLong();
        Long max = listOfRows.subList(startIndex, endIndex).stream().mapToLong(Long::longValue).max().getAsLong();
        return min + max;

    }

}

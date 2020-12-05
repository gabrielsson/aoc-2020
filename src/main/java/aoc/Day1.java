package aoc;

import java.util.List;

public class Day1 {
    public Object part1(List<Integer> listOfRows) {

        for(var i : listOfRows) {
            for (var j: listOfRows) {
                if(i+j == 2020) {
                    return i*j;
                }
            }
        }

        return 0;

    }

    public Object part2(List<Integer> listOfRows) {

        for(var i : listOfRows) {
            for (var j: listOfRows) {
                for( var k: listOfRows) {
                    if(i+j+k == 2020) {
                        return i*j*k;
                    }
                }

            }
        }

        return 0;
    }

}

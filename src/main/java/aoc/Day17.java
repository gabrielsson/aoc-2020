package aoc;

import aoc.points.AOCPoint3i;
import aoc.points.AOCPoint4i;

import javax.vecmath.Point3i;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static aoc.PuzzleInput.swapMatrix;

public class Day17 {
    public Object part1(char[][] mapXy) {
        Map<AOCPoint3i, Character> m = new HashMap<>();
        for (int x = 0; x < mapXy.length; x++) {
            for (int y = 0; y < mapXy[0].length; y++) {
                m.put(new AOCPoint3i(x - 1, y - 1, 0), mapXy[x][y]);
            }
        }

        for (int i = 0; i < 6; i++) {
            Map<AOCPoint3i, Character> newMap = new HashMap<>();
            List<AOCPoint3i> aocPoint3is = allNeightBours(m.keySet());
            Map<AOCPoint3i, Character> finalM = m;

            for (var n : aocPoint3is) {

                char value = finalM.getOrDefault(n, '.');

                if (value == '#') {
                    long count = n.neighbours().stream()
                        .map(t -> finalM.getOrDefault(t, '.'))
                        .filter(c -> '#' == c)
                        .count();
                    if (count == 3 || count == 2) {
                        newMap.put(n, '#');
                    } else {
                        newMap.put(n, '.');
                    }
                } else {
                    long count = n.neighbours().stream()
                        .map(t -> finalM.getOrDefault(t, '.'))
                        .filter(c -> '#' == c)
                        .count();
                    if (count == 3) {
                        newMap.put(n, '#');
                    } else {
                        newMap.put(n, '.');
                    }
                }
            }
            m = newMap;
            System.out.println(m.values().stream().filter(character -> '#' == character).count());
        }

        return m.values().stream().filter(character -> '#' == character).count();

    }

    private List<AOCPoint3i> allNeightBours(Set<AOCPoint3i> points) {
        Set<AOCPoint3i> all = new HashSet<>();
        for (var p : points) {
            all.addAll(p.neighbours());
        }

        return new ArrayList<>(all);

    }
    private List<AOCPoint4i> allNeightBours4(Set<AOCPoint4i> points) {
        Set<AOCPoint4i> all = new HashSet<>();
        for (var p : points) {
            all.addAll(p.neighbours());
        }

        return new ArrayList<>(all);

    }

    public Object part2(char[][] mapXy) {
        Map<AOCPoint4i, Character> m = new HashMap<>();
        for (int x = 0; x < mapXy.length; x++) {
            for (int y = 0; y < mapXy[0].length; y++) {
                m.put(new AOCPoint4i(x - 1, y - 1, 0, 0), mapXy[x][y]);
            }
        }

        for (int i = 0; i < 6; i++) {
            Map<AOCPoint4i, Character> newMap = new HashMap<>();
            List<AOCPoint4i> ps = allNeightBours4(m.keySet());
            Map<AOCPoint4i, Character> finalM = m;

            for (var n : ps) {

                char value = finalM.getOrDefault(n, '.');

                if (value == '#') {
                    long count = n.neighbours().stream()
                        .map(t -> finalM.getOrDefault(t, '.'))
                        .filter(c -> '#' == c)
                        .count();
                    if (count == 3 || count == 2) {
                        newMap.put(n, '#');
                    } else {
                        newMap.put(n, '.');
                    }
                } else {
                    long count = n.neighbours().stream()
                        .map(t -> finalM.getOrDefault(t, '.'))
                        .filter(c -> '#' == c)
                        .count();
                    if (count == 3) {
                        newMap.put(n, '#');
                    } else {
                        newMap.put(n, '.');
                    }
                }
            }
            m = newMap;
            System.out.println(m.values().stream().filter(character -> '#' == character).count());
        }

        return m.values().stream().filter(character -> '#' == character).count();


    }
}

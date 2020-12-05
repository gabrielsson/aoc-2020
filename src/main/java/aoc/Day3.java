package aoc;

public class Day3 {
    private static final char TREE = '#';

    public Object part1(char[][] map) {
        return countTrees(map, 1, 3);

    }

    public Object part2(char[][] map) {

        long a = countTrees(map, 1, 1);
        long b = countTrees(map, 1, 3);
        long c = countTrees(map, 1, 5);
        long d = countTrees(map, 1, 7);
        long e = countTrees(map, 2, 1);

        return a * b * c * d * e;

    }

    private long countTrees(char[][] map, int down, int right) {
        int trees = 0;
        for ( int x = 0, y = 0; y < map[0].length; y += down, x += right) {
            x %= map.length;
            if (map[x][y] == TREE) trees++;
        }
        return trees;
    }
}

package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static aoc.PuzzleInput.swapMatrix;

public class Day11 {
    public Object part1(char[][] seats) {

        char[][] current;

        do {
            current = Arrays.stream(seats)
                .map(char[]::clone)
                .toArray(char[][]::new);
            char[][] copy = Arrays.stream(seats)
                .map(char[]::clone)
                .toArray(char[][]::new);
            for (int x = 0; x < seats.length; x++) {
                for (int y = 0; y < seats[0].length; y++) {
                    modify(x, y, seats, copy);
                }
            }
            seats = Arrays.stream(copy)
                .map(char[]::clone)
                .toArray(char[][]::new);
            //printBoard(seats);
        } while (!arraysEqual(current, seats));

        int occupied = 0;
        for (int x = 0; x < seats.length; x++) {
            for (int y = 0; y < seats[0].length; y++) {
                if (seats[x][y] == '#') occupied++;
            }
        }

        return occupied;

    }

    private void printBoard(char[][] seats) {
        char[][] chars = swapMatrix(seats);

        StringBuffer sb = new StringBuffer();

        for (int x = 0; x < chars.length; x++) {
            for (int y = 0; y < chars[0].length; y++) {
                sb.append(chars[x][y]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private boolean arraysEqual(char[][] current, char[][] seats) {

        for (int x = 0; x < seats.length; x++) {
            if (!Arrays.equals(current[x], seats[x])) return false;
        }

        return true;

    }

    private void modify(int x, int y, char[][] seats, char[][] copy) {
        final int[][] NEIGHBOURS = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {1, 0},
            {-1, 1}, {0, 1}, {1, 1}
        };

        char c = seats[x][y];
        List<Character> statuses = new ArrayList<>();
        for (int[] direction : NEIGHBOURS) {

            int nx = x + direction[0];
            int ny = y + direction[1];
            if (nx < 0 || nx > seats.length - 1 || ny < 0 || ny > seats[0].length - 1) {
                continue;
            }
            statuses.add(seats[nx][ny]);

        }

        switch (c) {
            case 'L':
                if (statuses.stream().filter(s -> s == '#')
                    .count() == 0) {
                    copy[x][y] = '#';
                }
                ;
                break;
            case '#':
                if (statuses.stream().filter(s -> s == '#').count() >= 4) {
                    copy[x][y] = 'L';
                }
            default:
                break;
        }
    }

    public Object part2(char[][] seats) {

        char[][] current;

        do {
            current = Arrays.stream(seats)
                .map(char[]::clone)
                .toArray(char[][]::new);
            //printBoard(current);

            char[][] copy = Arrays.stream(seats)
                .map(char[]::clone)
                .toArray(char[][]::new);
            for (int x = 0; x < seats.length; x++) {
                for (int y = 0; y < seats[0].length; y++) {
                    modify2(x, y, seats, copy);
                }
            }
            seats = Arrays.stream(copy)
                .map(char[]::clone)
                .toArray(char[][]::new);

        } while (!arraysEqual(current, seats));
        //printBoard(seats);

        int occupied = 0;
        for (int x = 0; x < seats.length; x++) {
            for (int y = 0; y < seats[0].length; y++) {
                if (seats[x][y] == '#') occupied++;
            }
        }

        return occupied;

    }

    private void modify2(int x, int y, char[][] seats, char[][] copy) {
        final int[][] NEIGHBOURS = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {1, 0},
            {-1, 1}, {0, 1}, {1, 1}
        };

        char c = seats[x][y];

        Map<int[], Character> directionalOccupied = new HashMap<>();

        outer:
        for (int[] direction : NEIGHBOURS) {

            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx < 0 || nx > seats.length - 1 || ny < 0 || ny > seats[0].length - 1) {
                continue;
            }

            if (seats[nx][ny] == '.') {
                for (int i = 2; i < seats.length; i++) {
                    nx = x + direction[0] * i;
                    ny = y + direction[1] * i;
                    if (nx < 0 || nx > seats.length - 1 || ny < 0 || ny > seats[0].length - 1) {
                        continue outer;
                    }

                    if (seats[nx][ny] != '.') {
                        break;
                    }
                }

            }

            if (seats[nx][ny] == '#') {
                directionalOccupied.put(direction, seats[nx][ny]);
            }
        }

        switch (c) {
            case 'L':
                if (directionalOccupied.keySet().size() == 0) {
                    copy[x][y] = '#';
                }

                break;
            case '#':

                if (directionalOccupied.keySet().size() > 4) {
                    copy[x][y] = 'L';
                }
            default:
                break;
        }
    }

}

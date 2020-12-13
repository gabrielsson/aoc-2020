package aoc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day12 {
    public Object part1(List<String> listOfRows) {
        String facing = "E";

        Point p = new Point(0, 0);

        for (var row : listOfRows) {
            int value = Integer.valueOf(row.substring(1));
            String action = row.substring(0, 1);
            Point move = new Point(0, 0);
            switch (action) {
                case "F":
                    move = getMovement(facing, value);
                    break;
                case "R":
                    facing = rotateRight(facing, value / 90);
                    break;
                case "L":
                    facing = rotateLeft(facing, value / 90);
                    break;
                default:
                    move = getMovement(action, value);
                    break;
            }

            p.move(p.x + move.x, p.y + move.y);
        }

        return getManhattanDistance(new Point(0, 0), p);
    }

    private String rotateRight(String facing, int steps) {
        for (int i = 0; i < steps; i++) {
            switch (facing) {
                case "W":
                    facing = "N";
                    break;
                case "E":
                    facing = "S";
                    break;
                case "N":
                    facing = "E";
                    break;
                case "S":
                    facing = "W";
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return facing;
    }

    private String rotateLeft(String facing, int steps) {
        for (int i = 0; i < steps; i++) {
            switch (facing) {
                case "W":
                    facing = "S";
                    break;
                case "E":
                    facing = "N";
                    break;
                case "N":
                    facing = "W";
                    break;
                case "S":
                    facing = "E";
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return facing;
    }

    private Point getMovement(String action, int value) {

        Point move = new Point(0, 0);
        switch (action) {
            case "W":
                move.x -= value;
                break;
            case "E":
                move.x += value;
                break;
            case "N":
                move.y += value;
                break;
            case "S":
                move.y -= value;
                break;
            default:
                throw new RuntimeException();
        }
        return move;
    }

    private static Integer getManhattanDistance(Point p1, Point p2) {
        int distance = 0;
        distance += Math.abs(p1.getX() - p2.getX());
        distance += Math.abs(p1.getY() - p2.getY());
        return distance;
    }

    public Object part2(List<String> listOfRows) {


        Point ship = new Point(0, 0);
        Point waypoint = new Point(10,1);


        for (var row : listOfRows) {
            int value = Integer.valueOf(row.substring(1));
            String action = row.substring(0, 1);
            Point move;
            switch (action) {
                case "F":
                    move = new Point(waypoint.x*value, waypoint.y*value);
                    ship.move(ship.x + move.x, ship.y + move.y);
                    break;
                case "R":
                    waypoint = rotateWayPointRight(waypoint, value / 90);
                    break;
                case "L":
                    waypoint = rotateWayPointLeft(waypoint, value / 90);
                    break;
                default:
                    move = getMovement(action, value);
                    waypoint.move(waypoint.x + move.x, waypoint.y + move.y);
                    break;
            }
        }

        return getManhattanDistance(new Point(0, 0), ship);
    }

    private Point rotateWayPointLeft(Point waypoint, int times) {

        for(int i = 0; i < times; i++) {
            waypoint = new Point(- waypoint.y, waypoint.x );
        }
        return waypoint;
    }

    private Point rotateWayPointRight(Point waypoint, int times) {

        for(int i = 0; i < times; i++) {
            waypoint = new Point(waypoint.y, -waypoint.x );
        }
        return waypoint;
    }



}

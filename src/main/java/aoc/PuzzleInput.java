package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PuzzleInput {
    private String fileName;

    public PuzzleInput() {
        fileName = "day1.txt";
    }

    public PuzzleInput(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Scanner getInputScanner() {

        try {

            return new Scanner(new File("src/main/resources/" + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<Integer> getListOfNonSeparatedIntegers() {
        return getListOfSeparatedIntegers("\\B");
    }

    public List<Integer> getListOfSeparatedIntegers(String separator) {

        return Arrays.stream(getInputScanner().next().split(separator)).map(Integer::valueOf).collect(Collectors.toList());

    }

    public List<Long> getListOfSeparatedLong(String separator) {

        return Arrays.stream(getInputScanner().next().split(separator)).map(Long::valueOf).collect(Collectors.toList());

    }

    public List<String> getListOfSeparatedStrings(String separator) {

        return Arrays.stream(getInputScanner().next().split(separator)).collect(Collectors.toList());

    }


    public List<Integer> getListOfIntegers() {
        List<Integer> rows = new ArrayList<>();

        Scanner sc = getInputScanner();
        while(sc.hasNext()) {
            rows.add(Integer.valueOf(sc.next()));
        }

        return rows;

    }
    public List<String> getListOfRows() {
        List<String> rows = new ArrayList<>();
        Scanner scanner = getInputScanner();
        while (scanner.hasNextLine()) {
            rows.add(scanner.nextLine());
        }

        return rows;
    }

    private char[][] getMapYx() {
        List<String> listOfRows = getListOfRows();
        char[][] map = new char[listOfRows.size()][listOfRows.get(0).length()];
        for (int i = 0; i < listOfRows.size(); i++) {
            map[i] = listOfRows.get(i).toCharArray();
        }

        return map;
    }


    public char[][] getMapXy() {
        return swapMatrix(getMapYx());
    }

    private static char[][] swapMatrix(char[][] pField) {

        int originalTotalRows = pField.length;
        int originalTotalColumns = pField[0].length;

        char[][] newMatrix = new char[originalTotalColumns][originalTotalRows];

        for(int i=0; i< originalTotalRows; i++){
            for(int j=0; j < originalTotalColumns; j++){
                newMatrix[j][i] = pField[i][j];
            }
        }
        return newMatrix;
    }
}


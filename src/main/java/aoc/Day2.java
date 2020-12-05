package aoc;

import java.util.List;

public class Day2 {
    public Object part1(List<String> listOfRows) {
        return listOfRows.stream()
            .map(PasswordWithValidation::new)
            .filter(PasswordWithValidation::isValid)
            .count();
    }

    public Object part2(List<String> listOfRows) {

        return listOfRows.stream()
            .map(PasswordWithValidation::new)
            .filter(PasswordWithValidation::isValid2)
            .count();
    }

    private static class PasswordWithValidation {
        String password;
        int min;
        int max;
        char rule;

        public PasswordWithValidation(String row) {
            min = Integer.valueOf(row.substring(0,row.indexOf("-")));
            max = Integer.valueOf(row.substring(row.indexOf("-")+1, row.indexOf(" ")));
            rule = row.charAt(row.indexOf(":")-1);
            password = row.substring(row.lastIndexOf(" "));
        }

        public boolean isValid() {
            String replace = password.replaceAll(""+rule, "");
            int numberOfLetters = password.length() - replace.length();
            return numberOfLetters >= min && numberOfLetters <= max;
        }

        public boolean isValid2() {
            return password.charAt(min) == rule ^ password.charAt(max) == rule;
        }
    }

}

package aoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {
    public Object part1(List<String> listOfRows) {

        List<Passport> passports = new ArrayList<>();
        List<String> passportList = new ArrayList<>();
        for (var row : listOfRows) {

            if (row.trim().isEmpty()) {
                passports.add(new Passport(passportList));
                passportList.clear();
                continue;
            }
            passportList.add(row);
        }

        return passports.stream().filter(Passport::isValid).count();

    }

    public Object part2(List<String> listOfRows) {

        List<Passport> passports = new ArrayList<>();
        List<String> passportList = new ArrayList<>();
        for (var row : listOfRows) {

            if (row.trim().isEmpty()) {
                passports.add(new Passport(passportList));

                passportList.clear();
                continue;
            }
            passportList.add(row);


        }
        return passports.stream().filter(Passport::isValid).filter(Passport::isValid2).count();

    }

    @Data
    static class Passport {

        Map<String, String> fields = new HashMap<>();
        static List<String> mandatory = Arrays.asList("byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid");

        static String other = "cid";

        public Passport(List<String> passport) {
            for (String row : passport) {
                String[] s = row.split(" ");
                for (String field : s) {
                    String[] split = field.split(":");
                    fields.put(split[0], split[1]);
                }
            }
        }

        public boolean isValid() {
            return fields.keySet().containsAll(mandatory);
        }

        public boolean isValid2() {
            boolean result = false;
            List<String> eyeColor = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
            if (fields.keySet().containsAll(mandatory)) {
                try {
                    result = true;
                    String byr = fields.get("byr");
                    result = result && Integer.valueOf(byr) >= 1920 && Integer.valueOf(byr) <= 2002;
                    String iyr = fields.get("iyr");
                    result = result && Integer.valueOf(iyr) >= 2010 && Integer.valueOf(iyr) <= 2020;
                    String eyr = fields.get("eyr");
                    result = result && Integer.valueOf(eyr) >= 2020 && Integer.valueOf(eyr) <= 2030;

                    String hgt = fields.get("hgt");
                    String unit = hgt.substring(hgt.length() - 2);
                    String height = hgt.substring(0, hgt.length() - 2);
                    if ("cm".equals(unit)) {
                        result = result && Integer.valueOf(height) >= 150 && Integer.valueOf(height) <= 193;
                    } else if ("in".equals(unit)) {
                        result = result && Integer.valueOf(height) >= 59 && Integer.valueOf(height) <= 76;

                    } else {
                        result = false;
                    }
                    String reg = "#([a-f0-9]{6})";
                    String hcl = fields.get("hcl");
                    result = result && hcl.matches(reg);
                    String ecl = fields.get("ecl");

                    result = result && eyeColor.contains(ecl);
                    String pid = fields.get("pid");
                    result = result && pid.matches("([0-9]{9})");

                } catch (Exception e) {
                    return false;
                }

            }
            return result;
        }

    }

}

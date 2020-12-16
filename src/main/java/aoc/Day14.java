package aoc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day14 {
    public Object part1(List<String> listOfRows) {
        Map<Long, Long> mem = new HashMap<>();

        long currentOrMask = 0;
        long currentAndMask = 0;
        for (var row : listOfRows) {

            if (row.startsWith("mask")) {
                currentOrMask = Long.parseLong(row.substring(7).replace("X", "0"), 2);
                currentAndMask = ~Long.parseLong(row.substring(7).replace("1", "X")
                    .replace("0", "1")
                    .replace("X", "0"), 2);
            } else {
                Long memplace = Long.parseLong(row.substring(row.indexOf("[") + 1, row.indexOf("]")));
                Long value = Long.valueOf(row.substring(row.indexOf("=") + 2));
                value |= currentOrMask;
                value &= currentAndMask;
                mem.put(memplace, value);
            }

        }

        System.out.println(mem);
        return mem.values().stream().mapToLong(Long::longValue).sum();

    }

    public Object part2(List<String> listOfRows) {

        Map<Long, Long> mem = new HashMap<>();

        String currentOrMasks = "";
        for (var row : listOfRows) {

            if (row.startsWith("mask")) {
                String mask = row.substring(7);
                currentOrMasks = mask;
            } else {
                Long memplace = Long.parseLong(row.substring(row.indexOf("[") + 1, row.indexOf("]")));
                Set<Long> allMemoryPlaces = getAllMemoryPlaces(currentOrMasks, memplace);
                Long value = Long.valueOf(row.substring(row.indexOf("=") + 2));
                for (var m : allMemoryPlaces) {
                    mem.put(m, value);
                }
            }

        }
        BigInteger b = BigInteger.ZERO;

        for (Long l : mem.values()) {
            b = b.add(BigInteger.valueOf(l));
        }
        return b;

    }

    private Set<Long> getAllMemoryPlaces(String mask, Long memplace) {
        List<Integer> indices = new ArrayList<>();
        String mem = Long.toBinaryString(memplace);
        char[] maskedMemory = getMaskedMemory(mask.toCharArray(), mem.toCharArray());
        for (int i = 0; i < mask.length(); i++) {
            if (maskedMemory[i] == 'X') {
                indices.add(i);
                maskedMemory[i] = '0';
            }
        }
        Set<char[]> masks = new HashSet<>();

        masks.add(maskedMemory);
        for (var index : indices) {
            List<char[]> newMasks = new ArrayList<>();
            for (var m : masks) {
                char[] zero = Arrays.copyOf(m, m.length);
                char[] one = Arrays.copyOf(m, m.length);
                zero[index] = '0';
                one[index] = '1';
                newMasks.add(zero);
                newMasks.add(one);

            }

            masks.addAll(newMasks);

        }

        System.out.println();
        return masks.stream()
            .map(chars -> new String(chars))
            .map(m -> Long.valueOf(m, 2))
            .collect(Collectors.toSet());
    }

    private char[] getMaskedMemory(char[] mask, char[] mem) {
        char[] maskedMemory;
        if (mask.length > mem.length) {
            maskedMemory = Arrays.copyOf(mask, mask.length);
            for (int i = maskedMemory.length-1; i >= (mask.length-mem.length); i--) {
                if(maskedMemory[i] == '0') {
                    maskedMemory[i] = mem[i - mask.length + mem.length];
                }
            }
        } else {
            maskedMemory = Arrays.copyOf(mem, mem.length);
            for (int i = maskedMemory.length; i >= (mem.length-mask.length); i--) {
                if(maskedMemory[i] == '0') {
                    maskedMemory[i] = mem[i];
                }
            }
        }

        return maskedMemory;

    }

    private Set<Long> getAllMasks(String mask) {
        List<Integer> indices = new ArrayList<>();
        Set<char[]> masks = new HashSet<>();
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == 'X') {
                indices.add(i);
            }
        }

        char[] initialMask = mask.replace("X", "0").toCharArray();
        masks.add(initialMask);
        for (var index : indices) {
            List<char[]> newMasks = new ArrayList<>();
            for (var m : masks) {
                char[] zero = Arrays.copyOf(m, m.length);
                char[] one = Arrays.copyOf(m, m.length);
                zero[index] = '0';
                one[index] = '1';
                newMasks.add(zero);
                newMasks.add(one);

            }

            masks.addAll(newMasks);

        }

        System.out.println();
        return masks.stream()
            .map(chars -> new String(chars))
            .map(m -> Long.valueOf(m, 2))
            .collect(Collectors.toSet());
    }

}

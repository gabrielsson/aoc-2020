package aoc;

import lombok.Data;
import lombok.ToString;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day7 {
    public Object part1(List<String> listOfRows) {
        String name = "shiny gold";
        List<Bag> collect = listOfRows.stream()
            .map(Bag::new)
            .collect(Collectors.toList());


        Set<String> theHolders = new HashSet<>();
        theHolders.add(name);
        boolean found = false;
        do {
            for (Bag b : collect) {
                if (b.canHold(theHolders)) {
                    found = theHolders.add(b.name);
                }

            }
        } while (found);
        return theHolders.size() - 1;
    }




    public Object part2(List<String> listOfRows) {
        List<Bag> allBags = listOfRows.stream()
            .map(Bag::new)
            .collect(Collectors.toList());

        return countBags("shiny gold", allBags) - 1;

    }

    private int countBags(String name, List<Bag> allBags) {
        Bag bag = allBags.stream().filter(b -> b.name.equals(name)).findFirst().get();
        int count = 1;

        for (Map.Entry<Bag, Integer> entry : bag.bags.entrySet()) {
            count += entry.getValue() * countBags(entry.getKey().name, allBags);
        }

        return count;
    }

    @ToString
    @Data
    public static class Bag {

        String name;
        Map<Bag, Integer> bags = new HashMap<>();

        public Bag(String desc) {
            int beginningOfBags = desc.indexOf(" bags contain ");
            name = desc.substring(0, beginningOfBags);
            if (desc.indexOf("no other bags") < 0) {
                String[] split = desc.substring(beginningOfBags + 14).split(",");
                for (String s : split) {
                    s = s.trim();
                    s = s.replace(".", "");
                    var number = Integer.valueOf(s.substring(0, 1));
                    var subjectBagLength = number > 1 ? 5 : 4;
                    var subName = s.substring(2, s.length() - subjectBagLength);
                    Bag subBag = new Bag();
                    subBag.name = subName;
                    bags.put(subBag, Integer.valueOf(number));
                }
            }
        }
        public boolean canHold(Collection<String> ns) {
            for (Bag b : bags.keySet()) {
                if (ns.contains(b.name)) {
                    return true;
                }
            }
            return false;
        }

    }
}

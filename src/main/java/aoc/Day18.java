package aoc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.CalendarUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Day18 {
    public Object part1(List<String> listOfRows) {
        long sum = 0;
        for (String row : listOfRows) {
            sum += calculate(Arrays.asList(row.replace(" ", "").split("")), new AtomicInteger(0));

        }

        return sum;

    }

    private long calculate(List<String> expression, AtomicInteger index) {
        String sign = null;
        long sum = 0;
        for (; index.get() < expression.size(); index.incrementAndGet()) {

            String token = expression.get(index.get());
            if (StringUtils.isNumeric(token)) {
                if (sign == null) {
                    sum += Integer.parseInt(token);
                } else if (sign.equals("+")) {
                    sum += Integer.parseInt(token);
                } else if (sign.equals("*")) {
                    sum *= Integer.parseInt(token);
                }
            } else if ("(".equals(token)) {
                index.incrementAndGet();
                if ("+".equals(sign) || sign == null) {

                    sum += calculate(expression, index);
                } else {
                    sum *= calculate(expression, index);
                }
            } else if (")".equals(token)) {
                return sum;
            } else {
                sign = token;
            }

        }

        return sum;

    }

    public Object part2(List<String> listOfRows) {

        long sum = 0;
        for (String row : listOfRows) {

            sum += calculate2(Arrays.asList(row.replace(" ", "").split("")), new AtomicInteger(0));

        }

        return sum;

    }

    private long calculate2(List<String> expression, AtomicInteger index) {
        Deque<Long> numbers = new ArrayDeque<>();
        String sign = null;
        while (index.get() < expression.size()) {
            String token = expression.get(index.get());
            if (StringUtils.isNumeric(token)) {
                if(sign == null) {
                    numbers.offer(Long.valueOf(token));
                } else if (sign.equals("+")) {
                    Long v = numbers.pollLast();

                    numbers.offer(v+Long.valueOf(token));
                } else if (sign.equals("*")) {
                    numbers.offer(Long.valueOf(token));
                }
            } else if ("(".equals(token)) {
                index.incrementAndGet();

                if(sign != null && "*".equals(sign)) {
                    numbers.offer(calculate2(expression, index));
                } else {
                    Long v = numbers.pollLast();
                    if(v == null) {
                        v = 0L;
                    }
                    numbers.offer(v+calculate2(expression, index));

                }
            } else if (")".equals(token)) {
                return numbers.stream().mapToLong(Long::longValue).reduce(((l, l1) -> l*l1)).getAsLong();
            } else {

                sign = token;
            }
            index.incrementAndGet();
        }
        return numbers.stream().mapToLong(Long::longValue).reduce(((l, l1) -> l*l1)).getAsLong();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public class CalculationNumber {

        Long v1;
        Long v2;
        String sign;

        public CalculationNumber(CalculationNumber copy) {
            this.v1 = copy.v1;
            this.v2 = copy.v2;
            this.sign = copy.sign;
        }

        public long value() {
            if (sign.equals("+")) {
                return v1 + v2;
            } else if (sign.equals("*")) {
                return v1 * v2;
            }
            throw new RuntimeException();
        }
    }

}




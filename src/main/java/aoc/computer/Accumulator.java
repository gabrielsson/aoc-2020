package aoc.computer;

import lombok.Getter;

@Getter
public class Accumulator extends Instruction {
    Long argument;
    String name = "acc";
    public Accumulator(String s) {
        argument = Long.valueOf(s);
    }

    @Override
    public InstructionResult eval() {
        return InstructionResult.builder()
            .dAccumulator(argument)
            .dClk(1)
            .build();
    }
}

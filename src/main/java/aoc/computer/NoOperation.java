package aoc.computer;

import lombok.Getter;

@Getter
public class NoOperation extends Instruction {
    Long argument;
    String name = "nop";
    public NoOperation(String s) {
        this(Long.valueOf(s));
    }

    public NoOperation(Long a) {
        argument = a;
    }

    @Override
    public InstructionResult eval() {
        return InstructionResult.builder()
            .dAccumulator(0)
            .dClk(1)
            .build();
    }
}

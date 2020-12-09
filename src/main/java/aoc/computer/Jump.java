package aoc.computer;

import lombok.Getter;

@Getter
public class Jump extends Instruction {
    Long argument;
    String name = "jmp";
    public Jump(String s) {
        this(Long.valueOf(s));
    }

    public Jump(Long a) {
        argument = a;
    }
    @Override
    public InstructionResult eval() {
        return InstructionResult.builder()
            .dAccumulator(0)
            .dClk(argument)
            .build();
    }
}

package aoc.computer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InstructionResult {
    long dAccumulator;
    long dClk;
}

package aoc.computer;

public abstract class Instruction {

    public abstract String getName();
    public abstract Long getArgument();
    public abstract InstructionResult eval();

    public String toString() {
        return getName() + " " + (getArgument()<0? "":"+") + getArgument();
    }
}

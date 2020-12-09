package aoc.computer;

public class InstructionFactory {

    public static Instruction instruction(String s) {
        String[] instrArray = s.split(" ");

        switch (instrArray[0]) {
            case "acc":
                return new Accumulator(instrArray[1]);
            case "jmp":
                return new Jump(instrArray[1]);
            case "nop":
                return new NoOperation(instrArray[1]);
            default:
                throw new RuntimeException("Operation " + instrArray[0] + " with argument " + instrArray[1] + " not supported");
        }


    }
}

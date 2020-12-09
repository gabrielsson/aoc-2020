package aoc;

import aoc.computer.Accumulator;
import aoc.computer.Instruction;
import aoc.computer.InstructionFactory;
import aoc.computer.InstructionResult;
import aoc.computer.Jump;
import aoc.computer.NoOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day8 {
    public Object part1(List<String> listOfRows) {
        List<Instruction> program = listOfRows.stream().map(InstructionFactory::instruction).collect(Collectors.toList());

        int clk = 0;
        boolean isInfiniteLoop = false;
        Set<Integer> visited = new HashSet<>();
        Long accumulator = 0L;

        while (!isInfiniteLoop) {
            InstructionResult result = program.get(clk).eval();
            clk += result.getDClk();
            accumulator += result.getDAccumulator();
            isInfiniteLoop = !visited.add(clk);
        }

        return accumulator;

    }

    public Object part2(List<String> listOfRows) {

        List<Instruction> program = listOfRows.stream().map(InstructionFactory::instruction).collect(Collectors.toList());

        Long accumulator = 0L;
        running:
        for(int i = 0; i < program.size(); i++) {
            int clk = 0;
            boolean isInfiniteLoop = false;
            Set<Integer> visited = new HashSet<>();
            accumulator = 0L;
            List<Instruction> modifiedProgram = new ArrayList<>(program);

            Instruction instruction = modifiedProgram.get(i);
            if(instruction instanceof Accumulator) {
                continue;
            } else if(instruction instanceof Jump){
               var newInstr = new NoOperation(instruction.getArgument());
                modifiedProgram.set(i, newInstr);
            }else if(instruction instanceof NoOperation){
                var newInstr = new Jump(instruction.getArgument());
                modifiedProgram.set(i, newInstr);
            }

            System.out.println("____ new run ____");

            while (!isInfiniteLoop) {
                Instruction in = modifiedProgram.get(clk);
                System.out.println(in.toString());
                InstructionResult result = in.eval();
                clk += result.getDClk();
                accumulator += result.getDAccumulator();
                isInfiniteLoop = !visited.add(clk);
                if (clk >= modifiedProgram.size()) {
                    break running;
                }
            }
        }
        return accumulator;

    }

}

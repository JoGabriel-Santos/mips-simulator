import Datapath.*;
import Tools.LocalRegisters;
import Tools.ReturnData;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Memory> memoryList = Memory.initializeMemory(16);
        ArrayList<String> commands = Instructions.defineCommands();

        Registers registers;
        Control control;
        Instructions instructions;

        ArrayList<LocalRegisters> localRegisters = Registers.initializeRegisters();

        ALU ula = new ALU();
        PC pc = new PC();

        String[] commandRow = {
                "BEQ $s3 $s4 2",
                "SUB $s0 $s1 $s2",
                "J 4",
                "ADD $s0 $s1 $s2", "Exit"
        };

        String memoryTxt = "";

        System.out.println("Initializing...");
        printData(localRegisters, Memory.updateMemory(memoryList, commandRow, pc, 0), new Control());

        int pcCommand = pc.getValor() / 4;

        while (!commandRow[pcCommand + 1].equalsIgnoreCase("Exit")) {
            pcCommand = pc.getValor() / 4;

            separatorMain();
            System.out.println("Execution " + (pcCommand + 1));

            instructions = new Instructions(commands, commandRow, pc);

            String[] field = instructions.returnInstruction();

            control = new Control(field);

            if (control.isREGDST()) {
                registers = new Registers(control, /*rs*/ field[1], /*rt*/ field[2], /*rd*/ field[3], /*address*/ field[6], null);

            } else {
                registers = new Registers(control, /*rs*/ field[1], /*rt*/ field[2], /*rt*/ field[2], /*address*/ field[6], null);
            }

            ReturnData returnData = ula.performOperations(control, instructions, registers, localRegisters, memoryList);

            if (returnData.getRegisters() != null) {
                localRegisters = returnData.getRegisters();
            }

            if (returnData.getMemory() != null) {
                memoryList = returnData.getMemory();
            }

            pc = pc.update(control, pc, ula, /*address*/ field[6]);

            if (pcCommand + 1 == commandRow.length) {
                System.out.println("Done...");
            }

            memoryTxt = Memory.updateMemory(memoryList, commandRow, pc, 0);

            printData(localRegisters, memoryTxt, control);
        }

        System.out.println("\n\nDone...");
    }

    public static void printData(ArrayList<LocalRegisters> localRegisters, String memory, Control control) {
        boolean[] lineBreak = new boolean[28];

        lineBreak[2] = true;
        lineBreak[6] = true;
        lineBreak[14] = true;
        lineBreak[22] = true;
        lineBreak[24] = true;

        System.out.println("\nREGISTERS" + separator() + "\n");
        int index = 0;
        for (LocalRegisters registers : localRegisters) {
            if (lineBreak[index]) {
                System.out.println("\n");
            }
            index++;

            System.out.print("    " + registers.getName() + " - " + registers.getValueString() + "  |  ");
        }

        System.out.println("\n\n\nMEMORY" + separator() + "\n");
        System.out.println(memory);

        System.out.println("\n\nCONTROL" + separator() + "\n");
        System.out.println(control.toString());
    }

    public static void separatorMain() {
        System.out.println("\n\n_________________________________________________________________________________________________________________________________\n");
    }

    public static String separator() {
        return "------------------------------------------------------------------------";
    }
}

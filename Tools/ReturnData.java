package Tools;

import Datapath.Memory;

import java.util.ArrayList;

public class ReturnData {

    private final ArrayList<LocalRegisters> registers;
    private final ArrayList<Memory> memory;

    public ReturnData(ArrayList<LocalRegisters> registers, ArrayList<Memory> memory) {
        this.registers = registers;
        this.memory = memory;
    }

    public ArrayList<LocalRegisters> getRegisters() {
        return registers;
    }

    public ArrayList<Memory> getMemory() {
        return memory;
    }
}

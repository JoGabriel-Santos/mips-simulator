package Instructions;

import Datapath.Memory;
import Tools.LocalRegisters;
import Tools.ReturnData;
import java.util.ArrayList;

public class Sw {

    private final ArrayList<LocalRegisters> registersList;
    ArrayList<Memory> memory;

    private final String r1;
    private final String r2;
    private final Integer immediate;

    public Sw(ArrayList<LocalRegisters> registersList, ArrayList<Memory> memory, String r1, String r2, String immediate) {
        this.registersList = registersList;
        this.memory = memory;

        this.r1 = r1;
        this.r2 = r2;
        this.immediate = Integer.parseInt(immediate);
    }

    public ReturnData performOperation() {
        LocalRegisters register_1 = null, register_2 = null;

        for (LocalRegisters register : registersList) {
            if (register.getName().equals(r1)) {
                register_1 = register;
            }

            if (register.getName().equals(r2)) {
                register_2 = register;
            }
        }

        if (register_1 != null && register_2 != null) {

            memory.get(register_2.getValue() + immediate).setValue(register_1.getValueString());
        }

        return new ReturnData(registersList, memory);
    }
}

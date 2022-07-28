package Instructions;

import Tools.LocalRegisters;
import Tools.ReturnData;
import java.util.ArrayList;

public class Addi {

    private final ArrayList<LocalRegisters> registersList;

    private final String r1;
    private final String r2;
    private final Integer immediate;

    public Addi(ArrayList<LocalRegisters> registersList, String r1, String r2, String immediate) {
        this.registersList = registersList;

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

            register_1.setValue(register_2.getValue() + immediate);
        }

        return new ReturnData(registersList, null);
    }
}

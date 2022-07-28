package Instructions;

import Tools.LocalRegisters;
import Tools.ReturnData;
import java.util.ArrayList;

public class Beq {

    private final ArrayList<LocalRegisters> registersList;

    private final String r1;
    private final String r2;

    private boolean zero = false;

    public Beq(ArrayList<LocalRegisters> registersList, String r1, String r2) {
        this.registersList = registersList;

        this.r1 = r1;
        this.r2 = r2;
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

            if (register_1.getValue() - register_2.getValue() == 0) {
                zero = true;
            }
        }

        return new ReturnData(registersList, null);
    }

    public boolean getZero() {
        return zero;
    }
}

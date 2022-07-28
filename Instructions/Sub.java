package Instructions;

import Tools.LocalRegisters;
import Tools.ReturnData;
import java.util.ArrayList;

public class Sub {

    private final ArrayList<LocalRegisters> registersList;

    private final String r1;
    private final String r2;
    private final String r3;

    public Sub(ArrayList<LocalRegisters> registersList, String r1, String r2, String r3) {
        this.registersList = registersList;
        
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    public ReturnData performOperation() {
        LocalRegisters register1 = null, register_2 = null, register_3 = null;

        for (LocalRegisters register : registersList) {
            if (register.getName().equals(r1)) {
                register1 = register;
            }

            if (register.getName().equals(r2)) {
                register_2 = register;
            }

            if (register.getName().equals(r3)) {
                register_3 = register;
            }
        }

        if (register1 != null && register_2 != null && register_3 != null) {

            register1.setValue(register_2.getValue() - register_3.getValue());
        }

        return new ReturnData(registersList, null);
    }
}

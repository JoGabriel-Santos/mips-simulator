package Instructions;

import Tools.LocalRegisters;
import Tools.ReturnData;
import java.util.ArrayList;

public class And {

    private final ArrayList<LocalRegisters> registersList;

    private final String r1;
    private final String r2;
    private final String r3;

    public And(ArrayList<LocalRegisters> registersList, String r1, String r2, String r3) {
        this.registersList = registersList;
        
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    public ReturnData performOperation() {
        LocalRegisters register_1 = null, register_2 = null, register_3 = null;

        for (LocalRegisters register : registersList) {
            if (register.getName().equals(r1)) {
                register_1 = register;
            }

            if (register.getName().equals(r2)) {
                register_2 = register;
            }

            if (register.getName().equals(r3)) {
                register_3 = register;
            }
        }

        if (register_1 != null && register_2 != null && register_3 != null) {

            register_1.setValue(register_2.getValue() == 1 && register_3.getValue() == 1 ? 1 : 0);
        }

        return new ReturnData(registersList, null);
    }
}

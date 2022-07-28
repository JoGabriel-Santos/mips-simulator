package Datapath;

public class Control {
    private String ALUCONTROL;
    private String opCode;

    private boolean REGDST;
    private boolean JUMP;
    private boolean BRANCH;
    private boolean MEMREAD;
    private boolean MEMTOREG;
    private boolean MEMWRITE;
    private boolean ALUSRC;
    private boolean REGWRITE;

    public Control() {
    }

    public Control(String[] field) {

        opCode = field[0];

        disableSignals();

        switch (opCode) {
            case "0" -> {
                // R-Type
                REGDST = true;

                ALUCONTROL = "10";
            }

            case "1" -> {
                // ADDI
                ALUSRC = true;

                ALUCONTROL = "11";
            }

            case "2" -> {
                // LW
                MEMREAD = true;
                MEMTOREG = true;
                REGWRITE = true;

                ALUCONTROL = "00";
            }

            case "3" -> {
                // SW
                MEMWRITE = true;

                ALUCONTROL = "00";
            }

            case "4" -> {
                // BEQ
                BRANCH = true;

                ALUCONTROL = "01";
            }

            case "5" -> {
                // J
                JUMP = true;
            }
        }
    }

    public void disableSignals() {
        REGDST   = false;
        JUMP     = false;
        BRANCH   = false;
        MEMREAD  = false;
        MEMTOREG = false;
        MEMWRITE = false;
        REGWRITE = false;
    }

    public String getALUCONTROL() {
        return ALUCONTROL;
    }

    public boolean isREGDST() {
        return REGDST;
    }

    public boolean isJUMP() {
        return JUMP;
    }

    public boolean isBRANCH() {
        return BRANCH;
    }

    public boolean isMEMREAD() {
        return MEMREAD;
    }

    public boolean isMEMTOREG() {
        return MEMTOREG;
    }

    public boolean isMEMWRITE() {
        return MEMWRITE;
    }

    public boolean isALUSRC() {
        return ALUSRC;
    }

    public boolean isREGWRITE() {
        return REGWRITE;
    }

    @Override
    public String toString() {
        return "    ALUControl = " + ALUCONTROL
                + "\n\n        RegDst = " + REGDST
                + "\n\n          Jump = " + JUMP
                + "\n\n        Branch = " + BRANCH
                + "\n\n       MemRead = " + MEMREAD
                + "\n\n      MemToReg = " + MEMTOREG
                + "\n\n      MemWrite = " + MEMWRITE
                + "\n\n        ALUSrc = " + ALUSRC
                + "\n\n      RegWrite = " + REGWRITE;
    }
}

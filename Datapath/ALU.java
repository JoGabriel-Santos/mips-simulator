package Datapath;

import Instructions.Add;
import Instructions.Addi;
import Instructions.And;
import Instructions.Beq;
import Instructions.Lw;
import Instructions.Or;
import Instructions.Sub;
import Instructions.Sw;

import Tools.LocalRegisters;
import Tools.ReturnData;

import java.util.ArrayList;

public class ALU {
    ReturnData returnData;

    Beq beq;

    public ReturnData performOperations
            (Control control, Instructions instructions, Registers registers, ArrayList<LocalRegisters> registersList, ArrayList<Memory> memory) {

        switch (control.getALUCONTROL()) {
            case "10" -> {
                switch (instructions.getFunct()) {
                    case "1" -> {
                        if (control.isREGDST()) {
                            Add add = new Add(registersList, registers.getWriteReg(), registers.getReadReg_1(), registers.getReadReg_2());
                            returnData = add.performOperation();
                        }
                    }

                    case "2" -> {
                        if (control.isREGDST()) {
                            Sub sub = new Sub(registersList, registers.getWriteReg(), registers.getReadReg_1(), registers.getReadReg_2());
                            returnData = sub.performOperation();
                        }
                    }

                    case "3" -> {
                        if (control.isREGDST()) {
                            And and = new And(registersList, registers.getWriteReg(), registers.getReadReg_1(), registers.getReadReg_2());
                            returnData = and.performOperation();
                        }
                    }

                    case "4" -> {
                        if (control.isREGDST()) {
                            Or or = new Or(registersList, registers.getWriteReg(), registers.getReadReg_1(), registers.getReadReg_2());
                            returnData = or.performOperation();
                        }
                    }
                }
            }

            case "11" -> {
                if (control.isALUSRC()) {
                    Addi andi = new Addi(registersList, registers.getWriteReg(), registers.getReadReg_1(), registers.getAddress());
                    returnData = andi.performOperation();
                }
            }

            case "00" -> {
                if (control.isMEMREAD() && control.isMEMTOREG() && control.isREGWRITE()) {
                    Lw lw = new Lw(registersList, memory, registers.getWriteReg(), registers.getReadReg_1(), registers.getAddress());
                    returnData = lw.performOperation();
                }

                if (control.isMEMWRITE()) {
                    Sw sw = new Sw(registersList, memory, registers.getWriteReg(), registers.getReadReg_1(), registers.getAddress());
                    returnData = sw.performOperation();
                }
            }

            case "01" -> {
                if (control.isBRANCH()) {
                    beq = new Beq(registersList, registers.getReadReg_1(), registers.getReadReg_2());
                    returnData = beq.performOperation();
                }
            }
        }

        return returnData;
    }

    public Beq getBeq() {
        return beq;
    }
}

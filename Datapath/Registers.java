package Datapath;

import Tools.LocalRegisters;

import java.util.ArrayList;

public class Registers {

    static ArrayList<LocalRegisters> localRegisters = new ArrayList<>();

    private final Control control;

    private final String readReg_1;
    private final String readReg_2;
    private final String writeReg;
    private final String writeData;
    private final String address;

    public Registers(Control control, String readReg_1, String readReg_2, String writeReg, String writeData, String address) {
        this.control = control;
        this.readReg_1 = readReg_1;
        this.readReg_2 = readReg_2;
        this.writeReg = writeReg;
        this.writeData = writeData;
        this.address = address;
    }

    public static ArrayList<LocalRegisters> initializeRegisters() {
        localRegisters.add(new LocalRegisters("$v0", "0"));
        localRegisters.add(new LocalRegisters("$v1", "0"));

        localRegisters.add(new LocalRegisters("$a0", "0"));
        localRegisters.add(new LocalRegisters("$a1", "0"));
        localRegisters.add(new LocalRegisters("$a2", "0"));
        localRegisters.add(new LocalRegisters("$a3", "0"));

        localRegisters.add(new LocalRegisters("$t0", "2"));
        localRegisters.add(new LocalRegisters("$t1", "0"));
        localRegisters.add(new LocalRegisters("$t2", "0"));
        localRegisters.add(new LocalRegisters("$t3", "8"));
        localRegisters.add(new LocalRegisters("$t4", "0"));
        localRegisters.add(new LocalRegisters("$t5", "0"));
        localRegisters.add(new LocalRegisters("$t6", "0"));
        localRegisters.add(new LocalRegisters("$t7", "0"));

        localRegisters.add(new LocalRegisters("$s0", "0"));
        localRegisters.add(new LocalRegisters("$s1", "2"));
        localRegisters.add(new LocalRegisters("$s2", "4"));
        localRegisters.add(new LocalRegisters("$s3", "5"));
        localRegisters.add(new LocalRegisters("$s4", "5"));
        localRegisters.add(new LocalRegisters("$s5", "0"));
        localRegisters.add(new LocalRegisters("$s6", "6"));
        localRegisters.add(new LocalRegisters("$s7", "0"));

        localRegisters.add(new LocalRegisters("$t8", "0"));
        localRegisters.add(new LocalRegisters("$t9", "0"));

        localRegisters.add(new LocalRegisters("$gp", "0"));
        localRegisters.add(new LocalRegisters("$sp", "0"));
        localRegisters.add(new LocalRegisters("$fp", "0"));
        localRegisters.add(new LocalRegisters("$ra", "0"));

        return localRegisters;
    }

    public String getReadReg_1() {
        return readReg_1;
    }

    public String getReadReg_2() {
        return readReg_2;
    }

    public String getWriteReg() {
        return writeReg;
    }

    public String getAddress() {
        return address;
    }
}

package Datapath;

import java.util.ArrayList;

public class Instructions {
    private final ArrayList<String> commandList;
    private final String[] instructions;
    private final PC pc;

    private String instruction = "";
    private String register_1 = "";
    private String register_2 = "";
    private String register_3 = "";
    private String immediate = "";

    private String opCode = "";
    private String rs = "";
    private String rt = "";
    private String rd = "";
    private String shamt = "";
    private String funct = "";
    private String address = "";

    public Instructions(ArrayList<String> commandList, String[] instructions, PC pc) {
        this.commandList = commandList;
        this.instructions = instructions;
        this.pc = pc;

        returnInstruction();
    }

    public String[] returnInstruction() {

        String[] row = instructions[pc.getValor() / 4].split(" ");

        for (String r : row) {
            for (String s : commandList) {
                if (s.equalsIgnoreCase(r)) {
                    instruction = s.toLowerCase();

                    if (row.length == 2) {
                        identifyR1(row);

                    } else {
                        identifyR1(row);
                        identifyR2(row);

                        if (!row[3].contains("(")) {
                            identifyR3(row);
                        }
                    }
                }
            }
        }

        identifyType();

        String[] field = {opCode, rs, rt, rd, shamt, funct, address};

        return field;
    }

    public void identifyR1(String[] row) {
        if (row[1].contains("$")) {
            register_1 = row[1];

        } else {
            immediate = row[1];
        }
    }

    public void identifyR2(String[] row) {
        if (row[2].contains("$")) {
            register_2 = row[2];

        } else {
            register_2 = row[3].replace("(", "").replace(")", "");

            immediate = row[2];
        }
    }

    public void identifyR3(String[] row) {
        if (row[3].contains("$")) {
            register_3 = row[3];

        } else {
            immediate = row[3];
        }
    }

    public void identifyType() {
        switch (this.instruction) {
            case "add" -> {
                opCode = "0";
                rs = register_2;
                rt = register_3;
                rd = register_1;
                shamt = "xxxxx";
                funct = "1";
            }

            case "sub" -> {
                opCode = "0";
                rs = register_2;
                rt = register_3;
                rd = register_1;
                shamt = "xxxxx";
                funct = "2";
            }

            case "and" -> {
                opCode = "0";
                rs = register_2;
                rt = register_3;
                rd = register_1;
                shamt = "xxxxx";
                funct = "3";
            }

            case "or" -> {
                opCode = "0";
                rs = register_2;
                rt = register_3;
                rd = register_1;
                shamt = "xxxxx";
                funct = "4";
            }

            case "addi" -> {
                opCode = "1";
                rs = register_2;
                rt = register_1;
                address = immediate;
            }

            case "lw" -> {
                opCode = "2";
                rs = register_2;
                rt = register_1;
                address = immediate;
            }

            case "sw" -> {
                opCode = "3";
                rs = register_2;
                rt = register_1;
                address = immediate;
            }

            case "beq" -> {
                opCode = "4";
                rs = register_2;
                rt = register_1;
                address = immediate;
            }

            case "j" -> {
                opCode = "5";
                address = immediate;
            }
        }
    }

    public static ArrayList<String> defineCommands() {
        ArrayList<String> commands = new ArrayList<>();

        commands.add("add");
        commands.add("sub");
        commands.add("addi");
        commands.add("lw");
        commands.add("sw");
        commands.add("and");
        commands.add("or");
        commands.add("beq");
        commands.add("j");

        return commands;
    }

    public String getFunct() {
        return funct;
    }
}

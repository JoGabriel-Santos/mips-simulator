package Datapath;

import java.util.ArrayList;

public class Memory {

    static ArrayList<Memory> memory = new ArrayList<>();

    private final String position;
    private String value;

    public Memory(String position, String value) {
        this.position = position;
        this.value = value;
    }

    public static ArrayList<Memory> initializeMemory(int MEMORY_SIZE) {
        for (int index = 0; index <= MEMORY_SIZE; index++) {
            memory.add(new Memory(index % 4 == 0 ? String.valueOf(index) : "", ""));
        }

        return memory;
    }

    public static String updateMemory(ArrayList<Memory> memory, String[] commandRow, PC pc, int memoryPosition) {
        StringBuilder memoryText = new StringBuilder();

        memoryText.append("    ...\n");

        for (int index = 0, leap = 0; index < commandRow.length; index++, leap += 4) {
            memory.get(leap + memoryPosition).setValue(commandRow[index]);
        }

        int indexAux = 0;
        for (Memory mem : memory) {
            memoryText.append("\n    ").append(mem.getPosition()).append(" - ").append(mem.getValue()).append(indexAux == pc.getValor() + memoryPosition ? " <-" : "");
            indexAux++;
        }
        memoryText.append("\n\n    ...");

        return memoryText.toString();
    }

    public String getPosition() {
        return position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

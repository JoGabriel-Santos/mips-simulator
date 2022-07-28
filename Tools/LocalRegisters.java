package Tools;

public class LocalRegisters {

    private final String name;
    private String value;

    public LocalRegisters(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return Integer.parseInt(value);
    }

    public String getValueString() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = String.valueOf(value);
    }

    public void setValor(String value) {
        this.value = value;
    }
}

package Datapath;

public class PC {
    private int valor = 0;

    public PC update(Control control, PC pc, ALU ula, String address) {

        if (control.isJUMP()) {
            pc.valor = Integer.parseInt(address) * 4;

        } else if (control.isBRANCH() && ula.getBeq().getZero()) {
            pc.valor = pc.getValor() + 4 + (Integer.parseInt(address) * 4);

        } else {
            pc.valor = pc.getValor() + 4;
        }

        return pc;
    }

    public int getValor() {
        return valor;
    }
}

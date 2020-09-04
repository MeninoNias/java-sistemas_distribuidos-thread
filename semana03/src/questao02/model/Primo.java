package questao02.model;

public class Primo {

    private int numero;
    private String nomeThread;

    public Primo(int numero, String nomeThread) {
        this.numero = numero;
        this.nomeThread = nomeThread;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeThread() {
        return nomeThread;
    }

    public void setNomeThread(String nomeThread) {
        this.nomeThread = nomeThread;
    }

    @Override
    public String toString() {
        return "NºPrimo - " + numero +
                " Nome Thread - '" + nomeThread;
    }
}

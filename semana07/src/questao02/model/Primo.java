package src.questao02.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Primo primo = (Primo) o;
        return numero == primo.numero &&
                Objects.equals(nomeThread, primo.nomeThread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nomeThread);
    }

    @Override
    public String toString() {
        return "NºPrimo - " + numero +
                " Nome Thread - '" + nomeThread;
    }


}

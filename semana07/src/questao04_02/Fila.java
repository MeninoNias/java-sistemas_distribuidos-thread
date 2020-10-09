package src.questao04_02;

public class Fila{

    private boolean inserindo;

    private int inicio;
    private int fim;
    private int tamanho;
    private int qtdeElementos;
    private int f[];

    public Fila(int t){

        inicio = fim = -1;
        tamanho = t;
        f = new int[tamanho];
        qtdeElementos = 0;
    }

    public boolean isVazia(){
        return qtdeElementos == 0;
    }

    public boolean isCheia(){
        return qtdeElementos == tamanho - 1;
    }

    public boolean adicionar(Integer e){
        if (!isCheia()){
            if (inicio == -1){
                inicio = 0;
            }
            fim++;
            f[fim] = e;
            qtdeElementos++;
            return true;
        }
        return false;
    }

    public boolean remover(){
        if (!isVazia()){
            for(int i = 0; i < (tamanho-1); i++){
                f[i] = f[i+1];
            }
            fim--;
            qtdeElementos--;
            return true;
        }
        return false;
    }


    public int mostrarPrimeiro(){
        return f[0];
    }
    public int mostrarUltimo(){
        return f[fim];
    }

    public void mostrar(){
        for (int i = inicio; i<=fim; i++) {
            System.out.println(f[i]);
        }
    }

    public boolean isInserindo() {
        return inserindo;
    }

    public void setInserindo(boolean inserindo) {
        this.inserindo = inserindo;
    }
}


package questao04_02;

public class Fila{

    private boolean inserindo = true;

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
        if (qtdeElementos == 0){
            return true;
        }
        return false;
    }

    public boolean isCheia(){
        if (qtdeElementos == tamanho - 1){
            return true;
        }
        return false;
    }

    public void adicionar(int e){
        inserindo = false;
        if (!isCheia()){
            if (inicio == -1){
                inicio = 0;
            }
            fim++;
            f[fim] = e;
            qtdeElementos++;
        }
        inserindo = true;
    }

    public void remover(){
        inserindo = false;
        if (!isVazia()){
            for(int i = 0; i < (tamanho-1); i++){
                f[i] = f[i+1];
            }
            fim--;
            qtdeElementos--;
        }
        inserindo = true;
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
}


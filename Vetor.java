public class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    public void inserir(int valor) {
        elementos[tamanho] = valor;
        tamanho++;
    }
    public boolean buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return true;
            }
        }
        return false;
    }
    public int getTamanho() {
        return tamanho;
    }
    public int[] getElementos() {
        int[] resultado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = elementos[i];
        }
        return resultado;
    }
}
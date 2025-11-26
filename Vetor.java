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
    public int getTamanho() {
        return tamanho;
    }
    public int[] getElementos() {
        return elementos;
    }
}
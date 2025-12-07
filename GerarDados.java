import java.util.Random;

public class GerarDados {
    public int[] gerarCrescente(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = i + 1;
        }
        return dados;
    }
    public int[] gerarDecrescente(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = tamanho - i;
        }
        return dados;
    }

    public int[] gerarAleatorio(int tamanho) {
        Random random = new Random();
        int[] dados = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            dados[i] = random.nextInt(tamanho * 10);
        }

        return dados;
    }
}
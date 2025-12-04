public class MergeSort {
    public static void ordenar(int[] array) {
        if (array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }
    
    private static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }   
    private static void merge(int[] array, int inicio, int meio, int fim) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;
        
        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];
        
        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = array[inicio + i];
        }
        
        for (int j = 0; j < tamanhoDireita; j++) {
            direita[j] = array[meio + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = inicio;
        
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }
        
        while (i < tamanhoEsquerda) {
            array[k] = esquerda[i];
            i++;
            k++;
        }
        
        while (j < tamanhoDireita) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }
}
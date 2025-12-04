public class BubbleSort {
    public static void ordenar(int[] v) {
        for(int i = 0; i < v.length; i++){
            for (int j = 0; j < v.length - 1; j++) {
                if (v[j] > v[j + 1]){
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
    }
}
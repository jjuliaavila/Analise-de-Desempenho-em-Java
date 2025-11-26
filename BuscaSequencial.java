public class BuscaSequencial {
    public static boolean buscar(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
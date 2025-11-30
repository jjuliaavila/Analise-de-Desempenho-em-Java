public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== TESTE DE DESEMPENHO ===\n");
        
        System.out.println("--- 100 ELEMENTOS ---");
        testar(100);

        System.out.println("\n--- 1000 ELEMENTOS ---");
        testar(1000);

        System.out.println("\n--- 10000 ELEMENTOS ---");
        testar(10000);
    }
    
    public static void testar(int tamanho) {

        System.out.println("\nOrdem Crescente:");
        int[] crescente = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            crescente[i] = i + 1;
        }
        fazerTestes(crescente, tamanho);

        System.out.println("\nOrdem Decrescente:");
        int[] decrescente = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            decrescente[i] = tamanho - i;
        }
        fazerTestes(decrescente, tamanho);

        System.out.println("\nOrdem Aleatória:");
        int[] aleatoria = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            aleatoria[i] = (i * 7 + 13) % (tamanho * 2);
        }
        fazerTestes(aleatoria, tamanho);
    }
    
    public static void fazerTestes(int[] dados, int tamanho) {
        System.out.println("  Inserindo no Vetor...");
        Vetor vetor = new Vetor(tamanho);
        for (int i = 0; i < dados.length; i++) {
            vetor.inserir(dados[i]);
        }
        System.out.println("  Vetor: inserção concluída");

        System.out.println("  Inserindo na ABB...");
        ArvoreBinaria abb = new ArvoreBinaria();
        for (int i = 0; i < dados.length; i++) {
            abb.inserir(dados[i]);
        }
        System.out.println("  ABB: inserção concluída");

        System.out.println("  Inserindo na AVL...");
        ArvoreAVL avl = new ArvoreAVL();
        for (int i = 0; i < dados.length; i++) {
            avl.inserir(dados[i]);
        }
        System.out.println("  AVL: inserção concluída");
        
        int primeiro = dados[0];
        int ultimo = dados[dados.length - 1];
        int meio = dados[dados.length / 2];
        
        
        System.out.println("  Buscas:");

        boolean achouVetor = BuscaSequencial.buscar(vetor.getElementos(), primeiro);
        boolean achouABB = abb.buscar(primeiro);
        boolean achouAVL = avl.buscar(primeiro);
        System.out.println("    Primeiro elemento - Vetor: " + achouVetor + " | ABB: " + achouABB + " | AVL: " + achouAVL);

        achouVetor = BuscaSequencial.buscar(vetor.getElementos(), ultimo);
        achouABB = abb.buscar(ultimo);
        achouAVL = avl.buscar(ultimo);
        System.out.println("    Último elemento   - Vetor: " + achouVetor + " | ABB: " + achouABB + " | AVL: " + achouAVL);

        achouVetor = BuscaSequencial.buscar(vetor.getElementos(), meio);
        achouABB = abb.buscar(meio);
        achouAVL = avl.buscar(meio);
        System.out.println("    Meio              - Vetor: " + achouVetor + " | ABB: " + achouABB + " | AVL: " + achouAVL);
    }
}
public class Main {
    public static void main(String[] args) {

        System.out.println("===================================================");
        System.out.println("    ANÁLISE DE DESEMPENHO DE ESTRUTURAS DE DADOS   ");
        System.out.println("===================================================\n");

        GerarDados gerador = new GerarDados();
        int[] tamanhos = {100, 1000, 10000};

        System.out.println("\n===================================================");
        System.out.println("           TEMPO DE INSERÇÃO (ms)                  ");
        System.out.println("===================================================");
        System.out.printf("%-25s | %-10s | %-10s | %-10s |\n", "Tamanho/Ordem", "Vetor", "ABB", "AVL");
        System.out.println("--------------------------------------------------------------------");

        for (int tamanho : tamanhos) {
            int[] crescente = gerador.gerarCrescente(tamanho);
            testarInsercao(tamanho, "Crescente", crescente);
            
            int[] decrescente = gerador.gerarDecrescente(tamanho);
            testarInsercao(tamanho, "Decrescente", decrescente);
            
            int[] aleatorio = gerador.gerarAleatorio(tamanho);
            testarInsercao(tamanho, "Aleatório", aleatorio);
            
            System.out.println("--------------------------------------------------------------------");
        }

        System.out.println("\n===================================================");
        System.out.println("           TESTES CONCLUÍDOS                       ");
        System.out.println("===================================================");
    }

    public static void testarInsercao(int tamanho, String ordem, int[] dados) {
        int repeticoes = 5;

        long tempoVetorTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            Vetor vetor = new Vetor(tamanho);
            long inicio = System.nanoTime();
            for (int j = 0; j < dados.length; j++) {
                vetor.inserir(dados[j]);
            }
            long fim = System.nanoTime();
            tempoVetorTotal = tempoVetorTotal + (fim - inicio);
        }
        double tempoVetor = (tempoVetorTotal / repeticoes) / 1000000.0;

        long tempoABBTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            ArvoreBinaria abb = new ArvoreBinaria();
            long inicio = System.nanoTime();
            for (int j = 0; j < dados.length; j++) {
                abb.inserir(dados[j]);
            }
            long fim = System.nanoTime();
            tempoABBTotal = tempoABBTotal + (fim - inicio);
        }
        double tempoABB = (tempoABBTotal / repeticoes) / 1000000.0;

        long tempoAVLTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            ArvoreAVL avl = new ArvoreAVL();
            long inicio = System.nanoTime();
            for (int j = 0; j < dados.length; j++) {
                avl.inserir(dados[j]);
            }
            long fim = System.nanoTime();
            tempoAVLTotal = tempoAVLTotal + (fim - inicio);
        }
        double tempoAVL = (tempoAVLTotal / repeticoes) / 1000000.0;

        String cenario = tamanho + " / " + ordem;
        System.out.printf("%-25s | %-10.4f | %-10.4f | %-10.4f |\n", cenario, tempoVetor, tempoABB, tempoAVL);
    }
}
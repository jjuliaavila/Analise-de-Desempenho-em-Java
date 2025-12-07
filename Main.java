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
        System.out.println("           TEMPO DE BUSCA (ms)                     ");
        System.out.println("===================================================");

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Tamanho: " + tamanho + " elementos ---");

            int[] crescente = gerador.gerarCrescente(tamanho);
            System.out.println("\nOrdem Crescente:");
            testarBusca(crescente, tamanho);

            int[] decrescente = gerador.gerarDecrescente(tamanho);
            System.out.println("\nOrdem Decrescente:");
            testarBusca(decrescente, tamanho);

            int[] aleatorio = gerador.gerarAleatorio(tamanho);
            System.out.println("\nOrdem Aleatório:");
            testarBusca(aleatorio, tamanho);
        }

        System.out.println("\n===================================================");
        System.out.println("           TEMPO DE ORDENAÇÃO (ms)                 ");
        System.out.println("===================================================");
        System.out.printf("%-25s | %-15s | %-15s |\n", "Tamanho/Ordem", "BubbleSort", "MergeSort");
        System.out.println("--------------------------------------------------------------------");

        for (int tamanho : tamanhos) {
            int[] crescente = gerador.gerarCrescente(tamanho);
            testarOrdenacao(tamanho, "Crescente", crescente);

            int[] decrescente = gerador.gerarDecrescente(tamanho);
            testarOrdenacao(tamanho, "Decrescente", decrescente);

            int[] aleatorio = gerador.gerarAleatorio(tamanho);
            testarOrdenacao(tamanho, "Aleatório", aleatorio);

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
    public static void testarBusca(int[] dados, int tamanho) {
        int repeticoes = 5;

        Vetor vetor = new Vetor(tamanho);
        ArvoreBinaria abb = new ArvoreBinaria();
        ArvoreAVL avl = new ArvoreAVL();

        for (int i = 0; i < dados.length; i++) {
            vetor.inserir(dados[i]);
            abb.inserir(dados[i]);
            avl.inserir(dados[i]);
        }

        int[] vetorOrdenado = new int[dados.length];
        for (int i = 0; i < dados.length; i++) {
            vetorOrdenado[i] = dados[i];
        }
        MergeSort.ordenar(vetorOrdenado);

        int primeiro = dados[0];
        int ultimo = dados[dados.length - 1];
        int meio = dados[dados.length / 2];
        int aleatorio1 = dados[dados.length / 4];
        int aleatorio2 = dados[dados.length / 3];
        int aleatorio3 = dados[dados.length * 2 / 3];
        int inexistente = -999;

        int[] buscas = {primeiro, ultimo, meio, aleatorio1, aleatorio2, aleatorio3, inexistente};
        String[] nomes = {"Primeiro", "Último", "Meio", "Aleat1", "Aleat2", "Aleat3", "Inexist"};

        System.out.printf("%-12s | %-10s | %-10s | %-10s | %-10s |\n", "Elemento", "Vetor Seq", "Vetor Bin", "ABB", "AVL");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < buscas.length; i++) {
            int valorBusca = buscas[i];

            long tempoVetorSeqTotal = 0;
            for (int rep = 0; rep < repeticoes; rep++) {
                long inicio = System.nanoTime();
                BuscaSequencial.buscar(vetor.getElementos(), valorBusca);
                long fim = System.nanoTime();
                tempoVetorSeqTotal = tempoVetorSeqTotal + (fim - inicio);
            }
            double tempoVetorSeq = (tempoVetorSeqTotal / repeticoes) / 1000000.0;

            long tempoVetorBinTotal = 0;
            for (int rep = 0; rep < repeticoes; rep++) {
                long inicio = System.nanoTime();
                BuscaBinaria.buscar(vetorOrdenado, valorBusca);
                long fim = System.nanoTime();
                tempoVetorBinTotal = tempoVetorBinTotal + (fim - inicio);
            }
            double tempoVetorBin = (tempoVetorBinTotal / repeticoes) / 1000000.0;

            long tempoABBTotal = 0;
            for (int rep = 0; rep < repeticoes; rep++) {
                long inicio = System.nanoTime();
                abb.buscar(valorBusca);
                long fim = System.nanoTime();
                tempoABBTotal = tempoABBTotal + (fim - inicio);
            }
            double tempoABB = (tempoABBTotal / repeticoes) / 1000000.0;

            long tempoAVLTotal = 0;
            for (int rep = 0; rep < repeticoes; rep++) {
                long inicio = System.nanoTime();
                avl.buscar(valorBusca);
                long fim = System.nanoTime();
                tempoAVLTotal = tempoAVLTotal + (fim - inicio);
            }
            double tempoAVL = (tempoAVLTotal / repeticoes) / 1000000.0;

            System.out.printf("%-12s | %-10.6f | %-10.6f | %-10.6f | %-10.6f |\n", 
                nomes[i], tempoVetorSeq, tempoVetorBin, tempoABB, tempoAVL);
        }
    }
    public static void testarOrdenacao(int tamanho, String ordem, int[] dados) {
        int repeticoes = 5;

        long tempoBubbleTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            int[] copia = new int[dados.length];
            for (int j = 0; j < dados.length; j++) {
                copia[j] = dados[j];
            }
            long inicio = System.nanoTime();
            BubbleSort.ordenar(copia);
            long fim = System.nanoTime();
            tempoBubbleTotal = tempoBubbleTotal + (fim - inicio);
        }
        double tempoBubble = (tempoBubbleTotal / repeticoes) / 1000000.0;

        long tempoMergeTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            int[] copia = new int[dados.length];
            for (int j = 0; j < dados.length; j++) {
                copia[j] = dados[j];
            }
            long inicio = System.nanoTime();
            MergeSort.ordenar(copia);
            long fim = System.nanoTime();
            tempoMergeTotal = tempoMergeTotal + (fim - inicio);
        }
        double tempoMerge = (tempoMergeTotal / repeticoes) / 1000000.0;

        String cenario = tamanho + " / " + ordem;
        System.out.printf("%-25s | %-15.4f | %-15.4f |\n", cenario, tempoBubble, tempoMerge);
    }
}
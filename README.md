# 📊 Análise de Desempenho de Estruturas de Dados em Java

## 📋 Descrição

Projeto desenvolvido para comparar o desempenho de diferentes estruturas de dados (**Vetor**, **Árvore Binária de Busca** e **Árvore AVL**) através de testes práticos de inserção, busca e ordenação. O objetivo é analisar o comportamento prático dessas estruturas e relacioná-lo com a complexidade teórica (Big O).

## 🎯 Objetivos

* Implementar estruturas de dados do zero sem bibliotecas prontas
* Medir tempos de inserção, busca e ordenação
* Comparar algoritmos simples (BubbleSort) e avançados (MergeSort)
* Analisar o impacto da ordem de inserção no desempenho
* Relacionar resultados práticos com teoria de complexidade

---

## 📁 Estrutura do Projeto
```
projeto/
│
├── ArvoreAVL.java           # Implementação da Árvore AVL com balanceamento
├── ArvoreBinaria.java       # Implementação da Árvore Binária de Busca
├── Vetor.java               # Implementação da estrutura Vetor
├── BubbleSort.java          # Algoritmo de ordenação O(n²)
├── MergeSort.java           # Algoritmo de ordenação O(n log n)
├── BuscaBinaria.java        # Busca binária para vetores ordenados
├── BuscaSequencial.java     # Busca sequencial para vetores
├── GerarDados.java          # Geração dos conjuntos de teste
├── Main.java                # Execução principal dos testes
└── README.md                # Este arquivo
```

---

## 💻 Como Compilar e Executar

### Compilação
```bash
javac *.java
```

### Execução
```bash
java Main
```

### Usando IDE

1. Abra o projeto em sua IDE (Eclipse, IntelliJ, VS Code)
2. Execute a classe `Main.java`

---

## 🧪 Metodologia dos Testes

### Tamanhos Testados

* 100 elementos
* 1.000 elementos
* 10.000 elementos

### Ordens de Inserção

* **Crescente**: 1, 2, 3, ..., N
* **Decrescente**: N, N-1, N-2, ..., 1
* **Aleatória**: ordem aleatória

### Processo de Medição

* Cada teste é executado **5 vezes**
* Tempo medido com `System.nanoTime()`
* Registra-se a **média** das 5 execuções
* Resultados em **milissegundos (ms)**

### Testes Realizados

#### 1. Inserção
Tempo para inserir todos os elementos em cada estrutura (Vetor, ABB, AVL) nos 9 cenários (3 tamanhos × 3 ordens).

#### 2. Busca
Para cada estrutura populada, busca de:
* Primeiro elemento
* Último elemento
* Elemento do meio
* Três elementos aleatórios
* Um elemento inexistente

**Para vetores**: Busca Sequencial e Busca Binária (após ordenação)

#### 3. Ordenação (apenas Vetores)
* BubbleSort
* MergeSort

---

## 📊 Saída do Programa

O programa exibe três tabelas formatadas:

### Tempo de Inserção
```
===================================================
           TEMPO DE INSERÇÃO (ms)                  
===================================================
Tamanho/Ordem             | Vetor      | ABB        | AVL        |
--------------------------------------------------------------------
100 / Crescente           | 0.0234     | 0.1456     | 0.2134     |
100 / Decrescente         | 0.0189     | 0.1523     | 0.2245     |
100 / Aleatório           | 0.0212     | 0.0987     | 0.1876     |
```

### Tempo de Busca
```
--- Tamanho: 100 elementos ---

Ordem Crescente:
Elemento     | Vetor Seq  | Vetor Bin  | ABB        | AVL        |
----------------------------------------------------------------
Primeiro     | 0.000234   | 0.000156   | 0.000198   | 0.000167   |
Último       | 0.001234   | 0.000189   | 0.000234   | 0.000201   |
```

### Tempo de Ordenação
```
===================================================
           TEMPO DE ORDENAÇÃO (ms)                 
===================================================
Tamanho/Ordem             | BubbleSort      | MergeSort       |
--------------------------------------------------------------------
100 / Crescente           | 0.3456          | 0.0234          |
```

---

## 🔧 Implementações

### Estruturas de Dados

**Vetor**
* Inserção: O(1)
* Busca Sequencial: O(n)
* Busca Binária: O(log n) - requer ordenação prévia

**Árvore Binária de Busca (ABB)**
* Inserção: O(log n) médio, O(n) pior caso
* Busca: O(log n) médio, O(n) pior caso
* Pode degenerar em lista em inserções ordenadas

**Árvore AVL**
* Inserção: O(log n) garantido
* Busca: O(log n) garantido
* Auto-balanceamento com 4 tipos de rotações

### Algoritmos de Ordenação

**BubbleSort**
* Complexidade: O(n²)
* Simples, adequado para poucos elementos

**MergeSort**
* Complexidade: O(n log n)
* Divide e conquista, eficiente para grandes conjuntos

---

## 📈 Complexidade Teórica

| Operação          | Vetor       | ABB (médio) | ABB (pior) | AVL      |
|-------------------|-------------|-------------|------------|----------|
| Inserção          | O(1)        | O(log n)    | O(n)       | O(log n) |
| Busca Sequencial  | O(n)        | -           | -          | -        |
| Busca             | -           | O(log n)    | O(n)       | O(log n) |
| Busca Binária     | O(log n)*   | -           | -          | -        |

*Requer vetor ordenado

---

## ⚠️ Observações Importantes

* ABB pode degenerar em O(n) com inserções ordenadas
* AVL mantém O(log n) mesmo no pior caso
* Para resultados precisos, execute sem outros programas pesados
* Tempos variam conforme hardware utilizado

---

## 👨‍💻 Autor

### Júlia Ávila Freixo
### Disciplina: Estrutura de Dados
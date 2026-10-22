import java.util.Scanner;

public class EscadaRecursiva {

    // Array (com long) para guardar os resultados já calculados (tabela de memoization)
    private static long[] memo;

    //Função que inicializa o array de memoization e chama a função recursiva.
    public static long calcularManeiras(int n) {
        if (n <= 0) return 0;

        // Criamos o array com tamanho (n + 1) para usar os índices de 1 até n diretamente
        memo = new long[n + 1];
        return numeroDeManeirasMemo(n);
    }

    //Função recursiva que calcula de quantas maneiras distintas (utilizando memoization)
    // é possível subir uma escada de 'n' degraus, avançando 1 ou 2 degraus por vez.
    public static long numeroDeManeirasMemo(int n) {
        // 1. CASOS BASE:
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 2. VERIFICAÇÃO NA MEMÓRIA:
        // Se o valor já foi calculado anteriormente (diferente de 0), retorna o valor salvo
        if (memo[n] != 0) {
        return Math.toIntExact(memo[n]);
        }

        // 3. CHAMADA RECURSIVA E MEMOIZATION:
        // Calcula o resultado e guarda no array antes de retornar
        // Segue a relação F(n) = F(n-1) + F(n-2)
        memo[n] = numeroDeManeirasMemo(n - 1) + numeroDeManeirasMemo(n - 2);
            return memo[n];
    }

    // 4. TESTE E INTERAÇÃO DA FUNÇÃO
    public static void main (String[] args) {

        System.out.println("--- Iniciando Testes da Função ---");

        // Matrizes de teste para validar o cenário: { {n, resultado_esperado} }
        int[][] cenariosDeTeste = {
                {2, 2}, // Exemplo do enunciado
                {3, 3}, // Exemplo do enunciado
                {4, 5}, // Exemplo do enunciado
                {5, 8}  // Teste extra
        };

        // Roda os testes automáticos utilizando a nova função com Memoization
        for (int[] teste : cenariosDeTeste) {
             int nTeste = teste[0];
             long esperado = teste[1];
             long resultadoTeste = calcularManeiras(nTeste);

             String status = (resultadoTeste == esperado) ? "✅ PASSOU" : "❌ FALHOU";
             System.out.printf("Para n = %d degraus | Resultado obtido: %d | Esperado: %d -> %s%n",
                    nTeste, resultadoTeste, esperado, status);
             }

             // Parte interativa com o usuário
             Scanner input = new Scanner(System.in);
             System.out.println("\n=== Cálculo de Maneiras de Subir a Escada ===\n");
             System.out.print("Digite o número de degraus da escada: ");

             if (input.hasNextInt()) {
                int nUsuario = input.nextInt();

                if (nUsuario <= 0) {
                    System.out.println("❌ Por favor, insira um número maior que 0.");
                } else {
                    long resultadoUsuario = calcularManeiras(nUsuario);
                    System.out.printf("Para uma escada de %d degraus, existem %d maneiras distintas de subir! 🚀%n",
                            nUsuario, resultadoUsuario);
                    System.out.println("Obrigado por jogar!");
                        }
                    } else {
                        System.out.println("❌ Entrada inválida! Digite apenas números inteiros.");
                    }
                    input.close();
    }
}
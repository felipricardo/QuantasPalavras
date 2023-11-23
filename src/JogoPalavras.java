import java.util.HashSet;
import java.util.Scanner;

public class JogoPalavras {
    private HashSet<String> palavras;
    private char letraSorteada;
    private boolean jogoAtivo;
    //test
    public JogoPalavras() {
        palavras = new HashSet<>();
        jogoAtivo = true;
    }

    public void sortearLetra() {
        letraSorteada = (char) ('a' + Math.random() * ('z' - 'a' + 1));
        System.out.println("A letra sorteada é: " + letraSorteada);
    }

    public void iniciarJogo() {
        sortearLetra();
        Scanner scanner = new Scanner(System.in);

        while (jogoAtivo) {
            System.out.println("Digite uma palavra que começa com a letra " + letraSorteada + " ou 'sair' para terminar o jogo:");
            String palavra = scanner.nextLine().toLowerCase();

            if (palavra.equals("sair")) {
                jogoAtivo = false;
            } else if (palavra.length() >= 4 && palavra.charAt(0) == letraSorteada) {
                if (palavras.contains(palavra)) {
                    System.out.println("Você já informou essa palavra!");
                } else {
                    palavras.add(palavra);
                }
            } else {
                System.out.println("Palavra inválida!");
            }
        }

        System.out.println("Jogo finalizado! Você informou " + palavras.size() + " palavras diferentes.");
        System.out.println("As palavras que você informou são: " + palavras);
    }

    public static void main(String[] args) {
        JogoPalavras jogo = new JogoPalavras();
        jogo.iniciarJogo();
    }
}
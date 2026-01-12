import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        
        System.out.println("Digite o caminho do arquivo de entrada");
        String caminho_entrada = sc.nextLine();

        System.out.println("Digite o caminho do arquivo de saída");
        String caminho_saida = sc.nextLine();

        leitor l = new leitor();
        String[] comandos = l.getLinhas(caminho_entrada);
        l.interpretador(comandos, caminho_saida);
        sc.close();
    }
}


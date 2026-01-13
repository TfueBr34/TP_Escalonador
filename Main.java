// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // System.out.println("Digite o caminho do arquivo de entrada seguido de seu nome");
        String caminho_entrada = args[0];
        int pos = caminho_entrada.lastIndexOf(".");
        String caminho_saida = caminho_entrada.substring(0, pos) +".out"+ caminho_entrada.substring(pos);

        leitor l = new leitor(args[1]);
        String[] comandos = l.getLinhas(caminho_entrada);
        l.interpretador(comandos, caminho_saida);
        // sc.close();
    }
}
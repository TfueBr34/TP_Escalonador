public class Main {
    public static void main(String[] args) {
        leitor l = new leitor();
        for(int i = 1; i <= 5; i++){
                String[] comandos = l.getLinhas("testes_TP2/teste"+i+".txt");
                l.interpretador(comandos, "saidas/teste"+i+"-out.txt");
            }
        }
}

public class Main {
    public static void main(String[] args) {
        leitor l = new leitor();
        for(int i = 1; i <= 5; i++){
                String[] comandos = l.getLinhas("C:/Users/samvi/OneDrive/Desktop/testes_TP2/teste"+i+".txt");
                l.interpretador(comandos, "C:/Users/samvi/OneDrive/Desktop/saidas/teste"+i+"-out.txt");
            }
        }
}

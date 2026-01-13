public class Main {
    public static void main(String[] args) {

        String caminho_entrada = args[0];
        int pos = caminho_entrada.lastIndexOf(".");
        String caminho_saida = caminho_entrada.substring(0, pos) +".out"+ caminho_entrada.substring(pos);

        if(args.length > 2){
            System.err.println(args[2]);
            leitor l = new leitor(args[2]);
            String[] comandos = l.getLinhas(caminho_entrada);
            l.interpretador(comandos, caminho_saida);

        }else{
            leitor l = new leitor("0");
            String[] comandos = l.getLinhas(caminho_entrada);
            l.interpretador(comandos, caminho_saida);
        }

    }
}
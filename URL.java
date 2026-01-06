
public class URL{
    private String url_completa;
    private String protocolo;
    private String host;
    private String caminho;
    private int profunfidade;

    public URL(String url){
        url_completa = url;
        protocolo = extrairProtocolo(url);
        host = extrairHost(url);
        caminho = extrairCaminho(url);
        profunfidade = extrairProfundidade(url);
    }

    public String extrairProtocolo(String url){
        try{
            int posicao = url.indexOf("://"); //encontra o index do ://
            if (posicao == -1) { // verifica se o index foi encontrado, caso não lança exceção
                throw new Exception("Not Found");
            }
            return  url.substring(0, posicao);//gera e retorna a subString com apenas o protocolo
        }catch(Exception e){
            return null;
        }
    }

    public String extrairHost(String url) {
        try {
            // Remove o protocolo
            int inicio = url.indexOf("://");
            if (inicio != -1) {
                url = url.substring(inicio + 3);
            }

            // Encontra o fim do host
            int fim = url.length();
            int barra = url.indexOf("/");

            //confirma se o host encerra com /
            if (barra != -1 && barra < fim) {
                fim = barra;
            };
            
            //coleta a substring do host dentro do url
            String host = url.substring(0, fim);

            // Remove www. se existir no início
            if (host.startsWith("www.")) {
                host = host.substring(4);
            }

            return host;

        } catch (Exception e) {
            return null;
        }
    }

    public String extrairCaminho(String url){
         try {
            // Remove o protocolo
            int inicio = url.indexOf("://");
            if (inicio != -1) {
                url = url.substring(inicio + 3);
            }

            // Remove o host
            int inicioPath = url.indexOf("/");
            if (inicioPath == -1) {
                return "/"; //caso o caminho seja a raiz retorna /
            }

            // Verifica fim do path
            int fim = url.length();
            int interrogacao = url.indexOf("?");
            int cerquilha = url.indexOf("#");

            if (interrogacao != -1 && interrogacao < fim){
                fim = interrogacao;
            };
            if (cerquilha != -1 && cerquilha < fim){
                fim = cerquilha;
            };

            return url.substring(inicioPath, fim); //retorna a substring contendo o caminho

        } catch (Exception e) {
            return null;
        }
    }

    public int extrairProfundidade(String url){
        try {
            String path = extrairCaminho(url);

            if(path == null || path == "/"){//verifica se o caminho é somente / e retorna profundidade 0
                return 0;
            }
            //remove a primeira barra e ultima barra(caso haja uma) do caminho, para no momento da contagem não haja um valor extra
            path = path.substring(1);
            if(path.endsWith("/")){
                path = path.substring(0, path.length()-1);
            }
            
            //retorna a quantidade de elementos de uma string contendo somente as / presentes na substring
            return path.split("/").length;

        } catch (Exception e) {
            return 0;
        }

    }

    //funções para retorno dos valores da variavel
    public String getProtocolo() {
        return protocolo;
    }

    public String getHost() {
        return host;
    }

    public String getCaminho() {
        return caminho;
    }

    public int getProfundidade() {
        return profunfidade;
    }

    public String getURL(){
        return url_completa;
    }
}
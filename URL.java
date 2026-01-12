public class URL {
    private String url_completa;
    private String protocolo;
    private String host;
    private String caminho;
    private int profundidade;
    URL proximo = null;
    URL anterior = null;

    public URL(String url) {
        // Remove www. e barra final para formatar a saída como desejado
        String urlTratada = url;
        
        // Remove barra final se existir
        if (urlTratada.endsWith("/")) {
            urlTratada = urlTratada.substring(0, urlTratada.length() - 1);
        }

        // Remove www. (considerando http e https)
        int indexProtocolo = urlTratada.indexOf("://");
        if (indexProtocolo != -1) {
            String prefixo = urlTratada.substring(0, indexProtocolo + 3); // http://
            String resto = urlTratada.substring(indexProtocolo + 3);
            if (resto.startsWith("www.")) {
                urlTratada = prefixo + resto.substring(4);
            }
        }

        this.url_completa = urlTratada;
        this.protocolo = extrairProtocolo(this.url_completa);
        this.host = extrairHost(this.url_completa);
        this.caminho = extrairCaminho(this.url_completa);
        this.profundidade = extrairProfundidade(this.url_completa);
    }

    public String extrairProtocolo(String url) {
        try {
            int posicao = url.indexOf("://");
            if (posicao == -1) {
                throw new Exception("Not Found");
            }
            return url.substring(0, posicao);
        } catch (Exception e) {
            return null;
        }
    }

    public String extrairHost(String url) {
        try {
            int inicio = url.indexOf("://");
            if (inicio != -1) {
                url = url.substring(inicio + 3);
            }
            int fim = url.length();
            int barra = url.indexOf("/");
            if (barra != -1 && barra < fim) {
                fim = barra;
            }
            String host = url.substring(0, fim);
            // O tratamento de www já foi feito no construtor, mas mantemos por segurança
            if (host.startsWith("www.")) {
                host = host.substring(4);
            }
            return host;
        } catch (Exception e) {
            return null;
        }
    }

    public String extrairCaminho(String url) {
        try {
            int inicio = url.indexOf("://");
            if (inicio != -1) {
                url = url.substring(inicio + 3);
            }
            int inicioPath = url.indexOf("/");
            if (inicioPath == -1) {
                return "/"; 
            }
            int fim = url.length();
            int interrogacao = url.indexOf("?");
            int cerquilha = url.indexOf("#");

            if (interrogacao != -1 && interrogacao < fim) {
                fim = interrogacao;
            }
            if (cerquilha != -1 && cerquilha < fim) {
                fim = cerquilha;
            }
            return url.substring(inicioPath, fim);

        } catch (Exception e) {
            return null;
        }
    }

    public int extrairProfundidade(String url) {
        try {
            String path = extrairCaminho(url);
            if (path == null || path.equals("/")) {
                return 0;
            }
            path = path.substring(1);
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            return path.split("/").length;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getProtocolo(){ 
        return protocolo; 
    }
    public String getHost(){ 
        return host; 
    }
    public String getCaminho(){ 
        return caminho; 
    }
    public int getProfundidade(){ 
        return profundidade; 
    }
    public String getURL(){ 
        return url_completa;
    }
}
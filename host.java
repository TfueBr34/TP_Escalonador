public class host {
    private String nomeHost;
    private listaURLS urls;

    public host(String nomeHost){
        this.nomeHost = nomeHost;
        this.urls = new listaURLS();
    }


    public void adicionarURL(String url){
        urls.inserirFim(url);
    }

    public void removerURL(String url){
        urls.removeURL(url);
    }

    public void limparURLS(){
        urls = new listaURLS();
    }

    public int quantidadeURL(){
        return urls.qtdURLS();
    }

    public String getNome(){
        return nomeHost;
    }

}

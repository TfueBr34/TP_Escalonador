public class Escalonador {

    private URL[] lista_urls;

    public void ADD_URLS(int quantidade, String[] urls) {
      if(lista_urls.length == 0){
        for(int i = 0; i < quantidade; i++){
          lista_urls[i] = new URL(urls[i]);
        }  
      }else{
        for(int i = 0; i < quantidade; i++){
          lista_urls[lista_urls.length+i] = new URL(urls[i]);
        }
      }
    } // adiciona ao escalonador as URLs informadas nas linhas seguintes. O parâmetro
      // <quantidade> indica quantas linhas serão lidas antes do próximo comando.

    public void ESCALONA_TUDO() {

    } // escalona todas as URLs seguindo as regras estabelecidas previamente. Quando
      // escalonadas, as URLs são exibidas e removidas da lista.

    public void ESCALONA(int quantidade) {

    } // limita a quantidade de URLs escalonadas.

    public void ESCALONA_HOST(String host, int quantidade) {

    } // São escalonadas apenas URLs deste host.

    public void VER_HOST(String host) {

    } // exibe todas as URLs do host, na ordem de prioridade.

    public void LISTA_HOSTS() {

    } // exibe todos os hosts, seguindo a ordem em que foram conhecidos.

    public void LIMPA_HOST(String host) {
      for (int i = 0; i < lista_urls.length; i++){
        if (lista_urls[i].getHost()== host) {
          lista_urls[i] = lista_urls[i+1];
        } //Fazer lista encadeada
      }
    } // limpa a lista de URLs do host.

    public void LIMPA_TUDO() {
      lista_urls = null;
    } // limpa todas as URLs, inclusive os hosts.
}
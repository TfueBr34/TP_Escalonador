public class Escalonador {

    private URL[] lista_urls;

    public void ADD_URLS(int quantidade) {

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

    } // limpa a lista de URLs do host.

    public void LIMPA_TUDO() {

    } // limpa todas as URLs, inclusive os hosts.
}
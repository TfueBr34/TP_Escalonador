public class Escalonador {

  // private URL[] lista_urls;
  private listaURLS listaURLS;

  public Escalonador() {
    listaURLS = new listaURLS();
  }

  public void ADD_URLS(int quantidade, String[] urls) {
    for (int i = 0; i < quantidade; i++) {
      listaURLS.inserirFim(urls[i]);
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

  public String[] VER_HOST(String host) {
    String[] urls = new String[listaURLS.qtdURLS()];
    String aux_url;
    int[] profundidade = new int[listaURLS.qtdURLS()];
    int aux_prof;
    URL url = listaURLS.getInicio();
    String host_url;

    while (url != null) {
      host_url = url.getHost();

      if (host_url == host) {
        urls[urls.length] = url.getURL();
        profundidade[profundidade.length] = url.getProfundidade();
      }

      for (int i = 0; i < profundidade.length; i++) {
        for (int j = 0; j < profundidade.length-1; j++) {
          if (profundidade[j] > profundidade[j + 1]) {
            aux_url = urls[j];
            urls[j] = urls[j + 1];
            urls[j + 1] = aux_url;
            aux_prof = profundidade[j];
            profundidade[j] = profundidade[j + 1];
            profundidade[j + 1] = aux_prof;
          }
        }
      }

      url = url.proximo;
    }

    return urls;
  } // exibe todas as URLs do host, na ordem de prioridade.

  public String[] LISTA_HOSTS() {
    String[] hosts = new String[listaURLS.qtdURLS()];
    URL url = listaURLS.getInicio();
    boolean presente = false;
    String host;

    while (url != null) {
      host = url.getHost();

      for (int i = 0; i < hosts.length; i++) {
        if (hosts[i].equals(host)) {
          presente = true;
          break;
        }
      }

      if (!presente) {
        hosts[hosts.length] = host;
      }

      url = url.proximo;
    }

    return hosts;
  } // exibe todos os hosts, seguindo a ordem em que foram conhecidos.

  public void LIMPA_HOST(String host) {
    URL url = listaURLS.getInicio();

    while (url != null) {
      if (url.getHost() == host) {
        if (url == listaURLS.getInicio()) {
          listaURLS.removerInicio();
        } else {
          if (url == listaURLS.getFim()) {
            listaURLS.removerFim();
          } else {
            url.anterior.proximo = url.proximo;
            url.proximo.anterior = url.anterior;
          }
        }
      }
    }

  } // limpa a lista de URLs do host.

  public void LIMPA_TUDO() {
    int qt_urls = listaURLS.qtdURLS();

    for (int i = qt_urls; i > 0; i--) {
      listaURLS.removerInicio();
    }
  } // limpa todas as URLs, inclusive os hosts.
}
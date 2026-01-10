public class Escalonador {

  // private URL[] lista_urls;
  private listaURLS listaURLS;

  public Escalonador() {
    listaURLS = new listaURLS();
  }

  public void ADD_URLS(int quantidade, String[] urls) {
    boolean presente = false;
    String[] urls_unique = new String[quantidade];
    for (int i = 0; i < quantidade; i++) {
      for (int j = 0; j <  urls_unique.length; j++) {
        if (urls_unique[j] != null) {
          if (urls_unique[j].equals(urls[i])) {
            presente = true;
            break;
          }
        }
      }

      if (!presente) {
        listaURLS.inserirFim(urls[i]);
        urls_unique[i] = urls[i];
      }
      
    }
  } // adiciona ao escalonador as URLs informadas nas linhas seguintes. O parâmetro
    // <quantidade> indica quantas linhas serão lidas antes do próximo comando.

  public int QTD_URLS_HOST(String host){
    int qt_urls = 0;
    URL url = listaURLS.getInicio();

    while (url != null) {
      if (host.equals(url.getHost())) {
        qt_urls++;
      }
      url =  url.proximo;
    }

    return qt_urls;
  }

  public String[] ESCALONA_TUDO() {
    int qt_total_urls    = listaURLS.qtdURLS();
    String[] urls        =  new String[qt_total_urls];
    String[] urls_host   =  new String[qt_total_urls];
    String[] hosts       =  LISTA_HOSTS();
    int qt_urls;
    int last_pos = 0;

    for (String host : hosts) {
      qt_urls = QTD_URLS_HOST(host);
      urls_host = ESCALONA_HOST(host, qt_urls);
      for (int i = 0; i < qt_urls; i++) {
        urls[last_pos] = urls_host[i];
        last_pos++;
      }
    }

    return urls;
    //pegar lista de hosts, escalono o host de cada lista e junto em um só
  } // escalona todas as URLs seguindo as regras estabelecidas previamente. Quando
    // escalonadas, as URLs são exibidas e removidas da lista.

  public String[] ESCALONA(int quantidade) {
    int qt_total_urls    = listaURLS.qtdURLS();
    String[] urls        =  new String[qt_total_urls];
    String[] urls_host   =  new String[qt_total_urls];
    String[] hosts       =  LISTA_HOSTS();
    int qt_urls;
    int last_pos = 0;

    for (String host : hosts) {
      if (quantidade == 0) {
        break;
      }
      qt_urls = QTD_URLS_HOST(host);
      if (qt_urls < quantidade) {
        quantidade -= qt_urls;
      }else{
        qt_urls = quantidade;
        quantidade = 0;
      }
      urls_host = ESCALONA_HOST(host, qt_urls);
      for (int i = 0; i < qt_urls; i++) {
        urls[last_pos] = urls_host[i];
        last_pos++;
      }
    }

    return urls;
    //MESMA COISA QUE A OUTRA, MAS A QUANTIDADE DE CADA URL CONTA PRA QUANTAS VEZES ESCALONAR
  } // limita a quantidade de URLs escalonadas.

  public String[] ESCALONA_HOST(String host, int quantidade) {
    String[] urls_host = VER_HOST(host);
    String[] host_escalonado = new String[quantidade];
    String url_lista;
    URL obj_url_lista = listaURLS.getInicio();

    for (int i = 0; i < host_escalonado.length; i++) {
      host_escalonado[i] = urls_host[i];
    }

    while (obj_url_lista != null) {
      url_lista = obj_url_lista.getURL();
      for (int i = 0; i < host_escalonado.length; i++) {
        if (host_escalonado[i] == url_lista) {
          listaURLS.removeURL(url_lista);
        }
      }
      obj_url_lista = obj_url_lista.proximo;
    }

    return host_escalonado;

  } // São escalonadas apenas URLs deste host.

  public String[] VER_HOST(String host) {
    String[] urls = new String[listaURLS.qtdURLS()];
    String aux_url;
    int[] profundidade = new int[listaURLS.qtdURLS()];
    int aux_prof;
    URL url = listaURLS.getInicio();
    String host_url;
    int pos_url = 0;
    int pos_prof = 0;

    while (url != null) {
      host_url = url.getHost();

      if (host_url.equals(host)) {
        urls[pos_url] = url.getURL();
        pos_url++;
        profundidade[pos_prof] = url.getProfundidade();
        pos_prof++;
      }

      for (int i = 0; i < profundidade.length; i++) {
        for (int j = 0; j < profundidade.length-1; j++) {
          if (urls[j] != null && urls[j+1] != null) {
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
    int pos = 0;

    while (url != null) {
      host = url.getHost();

      for (int i = 0; i < hosts.length; i++) {
        if (hosts[i] != null) {
          if (hosts[i].equals(host)) {
            presente = true;
            break;
          }
        }
      }

      if (!presente) {
        hosts[pos] = host;
        pos++;
      }

      url = url.proximo;
    }

    return hosts;
  } // exibe todos os hosts, seguindo a ordem em que foram conhecidos.

  public void LIMPA_HOST(String host) {
    URL url = listaURLS.getInicio();

    while (url != null) {
      if (host.equals(url.getHost())) {
        listaURLS.removeURL(url.getURL());
      }

      url = url.proximo;
    }

  } // limpa a lista de URLs do host.

  public void LIMPA_TUDO() {
    int qt_urls = listaURLS.qtdURLS();

    for (int i = qt_urls; i > 0; i--) {
      listaURLS.removerInicio();
    }
  } // limpa todas as URLs, inclusive os hosts.
}
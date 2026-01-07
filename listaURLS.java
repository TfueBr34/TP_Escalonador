public class listaURLS {

    private URL inicio;
    private URL fim;

    public listaURLS() {
        this.inicio = null;
        this.fim = null;
    }

    // Inserir no início na fila
    public void inserirInicio(String url) {
        URL novo = new URL(url);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    // Inserir no fim
    public void inserirFim(String url) {
        URL novo = new URL(url);

        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    // Remover do início
    public void removerInicio() {
        if (inicio == null) return;

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
    }

    // Remover do fim
    public void removerFim() {
        if (fim == null) return;

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
    }


}

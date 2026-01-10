public class teste{
    public static void main(String[] args) {
        Escalonador escala = new Escalonador();
        String[] urls = {"http://virtual.ufmg.br/20212/my/","http://www.globo.com/","http://github.com/marketplace/","http://virtual.ufmg.br/","http://github.com/collections/made-in-india/"};
        escala.ADD_URLS(5, urls);
        String[] hosts = escala.LISTA_HOSTS();
        // String[] url_hosts = escala.VER_HOST(hosts[0]);
        // escala.LIMPA_HOST(hosts[0]);
        // escala.LIMPA_TUDO();
        // String[] urls_esc = escala.ESCALONA_HOST(hosts[0],1);
        // String[] urls_esc = escala.ESCALONA_TUDO();
        String[] urls_esc = escala.ESCALONA(3);
    }
}

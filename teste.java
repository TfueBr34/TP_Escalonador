public class teste{
    public static void main(String[] args) {
        Escalonador escala = new Escalonador();
        String[] urls = {"http://virtual.ufmg.br/20212/my/","http://www.globo.com/","http://github.com/marketplace/","http://virtual.ufmg.br/","http://github.com/collections/made-in-india/"};
        escala.ADD_URLS(4, urls);
        escala.LIMPA_TUDO();
    }
}

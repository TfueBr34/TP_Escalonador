import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class leitor {

    // Lê o arquivo de entrada
    public String[] getLinhas(String path) {
        int total = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.readLine() != null) total++;
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }

        String[] linhas = new String[total];
        int i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas[i++] = linha.trim();
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return linhas;
    }

    // Interpreta comandos e escreve saída no TXT
    public void interpretador(String[] linhas, String arquivoSaida) {

        Escalonador escalonador = new Escalonador();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            for (int i = 0; i < linhas.length; i++) {

                if (linhas[i] == null || linhas[i].isEmpty())
                    continue;

                String[] partes = linhas[i].split("\\s+");
                String comando = partes[0];

                switch (comando) {

                    case "ADD_URLS": {
                        int qtd = Integer.parseInt(partes[1]);
                        String[] urls = new String[qtd];

                        for (int j = 0; j < qtd; j++) {
                            urls[j] = linhas[i + j + 1];
                        }

                        escalonador.ADD_URLS(qtd, urls);
                        i += qtd;
                        break;
                    }

                    case "LISTA_HOSTS": {
                        String[] hosts = escalonador.LISTA_HOSTS();
                        for (String h : hosts) {
                            if (h != null) {
                                bw.write(h);
                                bw.newLine();
                            }
                        }
                        break;
                    }

                    case "ESCALONA_HOST": {
                        String host = partes[1];
                        int qtd = Integer.parseInt(partes[2]);
                        String[] urls = escalonador.ESCALONA_HOST(host, qtd);

                        for (String u : urls) {
                            if (u != null) {
                                bw.write(u);
                                bw.newLine();
                            }
                        }
                        break;
                    }

                    case "ESCALONA_TUDO": {
                        // Mapeamento lógico
                        String[] urls = escalonador.ESCALONA_TUDO_PROF();
                        for (String u : urls) {
                            if (u != null) {
                                bw.write(u);
                                bw.newLine();
                            }
                        }
                        break;
                    }

                    case "LIMPA_TUDO": {
                        escalonador.LIMPA_TUDO();
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao escrever saída: " + e.getMessage());
        }
    }
}

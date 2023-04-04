import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer conexão HTTP e buscar os top 250 filmes
        //String imdbKey = System.getenv("IMDB_API_KEY");
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"; //+ imdbKey;
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();        

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            String frase= "";

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo.replace(':', '-') + ".png";

            var nota = new BigDecimal(filme.get("imDbRating"));

            switch(nota.setScale(0, RoundingMode.HALF_UP).intValue()){
                case 7: frase = "\"Podia ser melhor...\""; break;
                case 8: frase = "\"Até que é legal!\""; break;
                case 9: frase = "\"AMAZING!\""; break;
                default: break;
            }
            
            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo, frase);

            System.out.println(titulo);
            System.out.println();
        }
                
    }
}

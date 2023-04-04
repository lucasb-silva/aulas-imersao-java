import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Formatter;
import java.util.List;
import java.util.Map;


public class App {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
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
        char star = '\u2B50';
        Formatter fmt = new Formatter();
        Formatter title = new Formatter();
        title.format("%95s","");
        fmt.format("%50s %8s %108s\n", "Título","Poster","Classificação");
        for (Map<String,String> filme : listaDeFilmes) {
            var nota = new BigDecimal(filme.get("imDbRating"));            
            nota.setScale(0,RoundingMode.HALF_UP);
            char[] estrelas = new char[nota.intValue()];
            for(int i = 0; i < nota.intValue(); i++){
                estrelas[i] = star;
            }
            String classificacao = new String(estrelas);
            fmt.format("%50s %96s %18s\n", 
            filme.get("title"),
            filme.get("image"),
            classificacao+" ("+filme.get("imDbRating")+")");
        }
        System.out.println(title+ANSI_RED_BACKGROUND + "Filmes mais populares" + ANSI_RESET);
        System.out.println(fmt);
        
    }
}

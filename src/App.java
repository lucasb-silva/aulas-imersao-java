import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        API api = API.LINGUAGENS_FLY;

        // String NASAKey = System.getenv("NASA_API_KEY");
        String url = api.getUrl();// + NASAKey +"&start_date=2023-01-01";
        
        ExtratorDeConteudo extrator = api.getExtrator();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);       

        // exibir e manipular os dados        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        String frase = "AMAZING!";

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + (conteudo.titulo().replace(':', '-')).replace("\\", "-") + ".png";

            // var nota = new BigDecimal(conteudo.get("imDbRating"));

            // switch(nota.setScale(0, RoundingMode.HALF_UP).intValue()){
            //     case 7: frase = "\"Podia ser melhor...\""; break;
            //     case 8: frase = "\"Até que é legal!\""; break;
            //     case 9: frase = "\"AMAZING!\""; break;
            //     default: break;
            // }
            
            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo, frase);

            System.out.println(conteudo.titulo());
            System.out.println();
        }
                
    }
}

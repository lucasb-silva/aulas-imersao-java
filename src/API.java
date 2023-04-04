public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json", new ExtratorDeConteudoDoIMDB()),
    IMDB_TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=", new ExtratorDeConteudoDaNasa()),
    LINGUAGENS("http://localhost:8080/linguagens", new ExtratorDeConteudoDoIMDB()),
    LINGUAGENS_FLY("https://alura-linguagens-lucas.fly.dev/linguagens", new ExtratorDeConteudoDoIMDB());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator){
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}

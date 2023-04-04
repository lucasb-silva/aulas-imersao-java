import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo, String frase) throws Exception{

        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + Math.round((float)(Math.max(largura, altura)*0.15));

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        Font fonte = new Font("Impact",Font.BOLD,Math.round((float)(largura*0.1)));
        graphics.setFont(fonte);
        FontMetrics posicao = graphics.getFontMetrics(fonte); 
        int x = (largura - posicao.stringWidth(frase)) / 2;
        int y = novaAltura - Math.round((float)(Math.max(largura, altura)*0.05));
        
        Graphics2D g2d = (Graphics2D)graphics;
        AffineTransform transform = g2d.getTransform();
        transform.translate(x, y);
        g2d.transform(transform);
        g2d.setColor(Color.black);
        FontRenderContext fonteInterna = g2d.getFontRenderContext();
        TextLayout layoutInterno = new TextLayout(frase, graphics.getFont().deriveFont(Math.round((float)(largura*0.12))), fonteInterna);
        Shape shape = layoutInterno.getOutline(null);
        g2d.setStroke(new BasicStroke(Math.round((float)(largura*0.008))));
        g2d.draw(shape);
        g2d.setColor(Color.YELLOW);
        g2d.fill(shape);

        // escrever uma frase na nova imagem            
        g2d.drawString(frase, x, y);

        // escrever a nova imagem em um arquivo
        Files.deleteIfExists(Paths.get(nomeArquivo));
        ImageIO.write(novaImagem, "png", Files.createDirectories(Paths.get(nomeArquivo)).toFile());

    }
    
}

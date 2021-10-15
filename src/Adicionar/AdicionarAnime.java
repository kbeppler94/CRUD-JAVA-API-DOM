package Adicionar;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author ketlin
 */
public class AdicionarAnime {

    static public void main(String[] argv) {
        try {
            DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = b.newDocumentBuilder();
            Document myDoc = builder.parse("animes.xml");
            adiciona(myDoc);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void adiciona(Document doc) throws IOException, TransformerException {
        Element animes, anime, nome, temporada, titulo, episodio, lancamento, diretor, nomeDiretor, idade, produtora, nomeProdutora, endereco, logradouro, bairro, cidade, estado;
        Scanner leitura = new Scanner(System.in);

        animes = (Element) doc.getElementsByTagName("animes").item(0);

        anime = doc.createElement("anime");

        //define atributo e adiciona ao elemento
        System.out.print("Informe a posicao do anime: ");
        anime.setAttribute("posicao", leitura.nextLine());

        // define subelementos de manga
        nome = doc.createElement("nome");
        System.out.print("Informe o nome do anime: ");
        nome.appendChild(doc.createTextNode(leitura.nextLine()));
        anime.appendChild(nome);

        temporada = doc.createElement("temporada");
        System.out.print("Informe a temporada: ");
        temporada.appendChild(doc.createTextNode(leitura.nextLine()));
        anime.appendChild(temporada);

        titulo = doc.createElement("titulo");
        System.out.print("Informe o titulo do episodio: ");
        titulo.appendChild(doc.createTextNode(leitura.nextLine()));
        anime.appendChild(titulo);

        episodio = doc.createElement("episodio");
        System.out.print("Informe o numero do episodio: ");
        episodio.appendChild(doc.createTextNode(leitura.nextLine()));
        anime.appendChild(episodio);

        lancamento = doc.createElement("lancamento");
        System.out.print("Informe o ano de lancamento: ");
        lancamento.appendChild(doc.createTextNode(leitura.nextLine()));
        anime.appendChild(lancamento);

        //define elemento e subelementos
        diretor = doc.createElement("diretor");
        nomeDiretor = doc.createElement("nomeDiretor");
        System.out.print("Informe o nome do diretor: ");
        nomeDiretor.appendChild(doc.createTextNode(leitura.nextLine()));

        idade = doc.createElement("idade");
        System.out.print("Informe a idade: ");
        idade.appendChild(doc.createTextNode(leitura.nextLine()));

        produtora = doc.createElement("produtora");
        nomeProdutora = doc.createElement("nomeProdutora");
        System.out.print("Informe o nome da produtora: ");
        nomeProdutora.appendChild(doc.createTextNode(leitura.nextLine()));

        endereco = doc.createElement("endereco");
        logradouro = doc.createElement("logradouro");
        System.out.print("Informe o logradouro: ");
        logradouro.appendChild(doc.createTextNode(leitura.nextLine()));

        bairro = doc.createElement("bairro");
        System.out.print("Informe o bairro: ");
        bairro.appendChild(doc.createTextNode(leitura.nextLine()));
        endereco.appendChild(bairro);

        cidade = doc.createElement("cidade");
        System.out.print("Informe a cidade: ");
        cidade.appendChild(doc.createTextNode(leitura.nextLine()));
        endereco.appendChild(cidade);

        estado = doc.createElement("estado");
        System.out.print("Informe o estado: ");
        estado.appendChild(doc.createTextNode(leitura.nextLine()));
        endereco.appendChild(estado);

        endereco.appendChild(logradouro);
        endereco.appendChild(bairro);
        endereco.appendChild(cidade);
        endereco.appendChild(estado);
        produtora.appendChild(nomeProdutora);
        produtora.appendChild(endereco);
        diretor.appendChild(nomeDiretor);
        diretor.appendChild(idade);
        anime.appendChild(diretor);
        anime.appendChild(produtora);

        //adiciona no anime
        animes.appendChild(anime);

        animes.appendChild(doc.createComment("Anime adicionado com sucesso no CRUD!"));

        //serializa documento para arquivo
        XMLSerializer serializer = new XMLSerializer(
                new FileOutputStream("animes.xml"), new OutputFormat(doc, "iso-8859-1", true));
        serializer.serialize(doc);
    }
}

package Editar;

import com.sun.org.apache.xml.internal.serialize.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Kétlin
 */
public class EditarAnime {

    static public void main(String[] argv) {
        try {
            DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = b.newDocumentBuilder();
            Document myDoc = builder.parse("animes.xml");
            edita(myDoc);
        } catch (IOException | ParserConfigurationException | TransformerException | SAXException e) {
            System.out.println(e.toString());
        }
    }

    private static void edita(Document doc) throws TransformerException, IOException {
        Scanner leitura = new Scanner(System.in);
        int pos = -1;

        System.out.print("Informe a posição do Anime que deseja editar: ");
        String posicao = leitura.nextLine();

        NodeList nl = doc.getElementsByTagName("anime");

        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getAttributes().item(0).getNodeValue().equals(posicao)) {
                pos = i;
            }
        }

        if (pos == -1) {
            System.out.println("Anime não localizado!");
            return;
        }

        System.out.print("Informe o nome do Anime: ");
        doc.getElementsByTagName("nome").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a temporada: ");
        doc.getElementsByTagName("temporada").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o título: ");
        doc.getElementsByTagName("titulo").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o episódio: ");
        doc.getElementsByTagName("episodio").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a data de lançamento: ");
        doc.getElementsByTagName("lancamento").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o nome do diretor(a): ");
        doc.getElementsByTagName("nomeDiretor").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a idade do diretor: ");
        doc.getElementsByTagName("idade").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o nome da produtora: ");
        doc.getElementsByTagName("nomeProdutora").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a rua da produtora: ");
        doc.getElementsByTagName("rua").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o bairro: ");
        doc.getElementsByTagName("bairro").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a cidade: ");
        doc.getElementsByTagName("cidade").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe estado: ");
        doc.getElementsByTagName("estado").item(pos).setTextContent(leitura.nextLine());
        XMLSerializer serializer = new XMLSerializer(
                new FileOutputStream("animes.xml"), new OutputFormat(doc, "iso-8859-1", true));
        serializer.serialize(doc);
    }
}

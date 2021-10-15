package Consultar;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Kétlin
 */
public class ConsultarAnime {

    public static void main(String[] argv) {
        try {
            File xmlDoc = new File("animes.xml");
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFact.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlDoc);

            NodeList nl = doc.getElementsByTagName("anime");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                System.out.println("---------------------------------------------------");
                System.out.println(n.getNodeName() + " posição" + " " + (i + 1));
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;

                    System.out.println("Nome: "
                            + e.getElementsByTagName("nome").item(0).getTextContent());
                    System.out.println("Temporada: "
                            + e.getElementsByTagName("temporada").item(0).getTextContent());
                    System.out.println("Titulo: "
                            + e.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Episódio: "
                            + e.getElementsByTagName("episodio").item(0).getTextContent());
                    System.out.println("Ano de Lançamento: "
                            + e.getElementsByTagName("lancamento").item(0).getTextContent());
                    System.out.println("Nome do Diretor: "
                            + e.getElementsByTagName("nomeDiretor").item(0).getTextContent());
                    System.out.println("Idade: "
                            + e.getElementsByTagName("idade").item(0).getTextContent());
                    System.out.println("Nome da Produtora: "
                            + e.getElementsByTagName("nomeProdutora").item(0).getTextContent());
                    System.out.println("Logradouro: "
                            + e.getElementsByTagName("logradouro").item(0).getTextContent());
                    System.out.println("Bairro: "
                            + e.getElementsByTagName("bairro").item(0).getTextContent());
                    System.out.println("Cidade: "
                            + e.getElementsByTagName("cidade").item(0).getTextContent());
                    System.out.println("Estado: "
                            + e.getElementsByTagName("estado").item(0).getTextContent());

                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
    }

}

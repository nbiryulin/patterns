package lab1.strategy;

import lab1.sample.state.StateUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DomStrategy extends AbstractStrategy {
    private Document document;

    @Override
    protected Student readFile(String inputNameFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        document = documentBuilder.parse(inputNameFile);

        Element student = (Element) document.getElementsByTagName(StrategyUtils.STUDENT).item(0);
        NodeList subjects = student.getElementsByTagName(StrategyUtils.SUBJECT);

        return new Student(
                student.getAttribute(StrategyUtils.LASTNAME),
                IntStream.range(0, subjects.getLength())
                        .mapToObj(el -> {
                            Element element = (Element) subjects.item(el);
                            return new Subject(
                                    element.getAttribute(StrategyUtils.SUBJECT),
                                    Integer.parseInt(element.getAttribute(StrategyUtils.MARK)
                                    )
                            );
                        }).collect(Collectors.toCollection(ArrayList::new)),
                Double.parseDouble(student.getElementsByTagName(StrategyUtils.AVERAGE).item(0).getTextContent())
        );
    }

    @Override
    protected void writeFile(String outputNameFile, Student student) throws TransformerException {
        ((Element) document.getElementsByTagName(StrategyUtils.STUDENT).item(0))
                .getElementsByTagName(StrategyUtils.AVERAGE).item(0)
                .setTextContent(String.valueOf(student.getAverage()));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(outputNameFile));
    }

}

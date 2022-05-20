package lab1.strategy;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SaxStrategy extends AbstractStrategy {
    @Override
    protected Student readFile(String inputNameFile) throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        StudentHandler studentHandler = new StudentHandler();

        saxParser.parse(inputNameFile, studentHandler);

        return studentHandler.getStudent();
    }

    @Override
    protected void writeFile(String outputNameFile, Student student) {
        try (FileWriter fileWriter = new FileWriter(outputNameFile)) {
            XMLStreamWriter xMLStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(fileWriter);

            xMLStreamWriter.writeStartDocument("UTF-8", "1.0");

            xMLStreamWriter.writeStartElement(StrategyUtils.STUDENT);
            xMLStreamWriter.writeAttribute(StrategyUtils.LASTNAME, student.getLastName());

            student.getSubjects().forEach(subject -> {
                try {
                    xMLStreamWriter.writeEmptyElement(StrategyUtils.SUBJECT);
                    xMLStreamWriter.writeAttribute(StrategyUtils.MARK, String.valueOf(subject.getMark()));
                    xMLStreamWriter.writeAttribute(StrategyUtils.TITLE, subject.getSubjectName());
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            });

            xMLStreamWriter.writeStartElement(StrategyUtils.AVERAGE);
            xMLStreamWriter.writeCharacters(String.valueOf(student.getAverage()));
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();
        } catch (IOException | XMLStreamException exception) {
            exception.printStackTrace();
        }
    }

}

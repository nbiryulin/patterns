package lab1.strategy;


import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StudentHandler extends DefaultHandler {
    private Student student;
    private boolean isAverage = false;

    public Student getStudent() {
        return student;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase(StrategyUtils.STUDENT)) {
            student = new Student();
            student.setLastName(attributes.getValue(StrategyUtils.LASTNAME));

            return;
        }

        if (qName.equalsIgnoreCase(StrategyUtils.SUBJECT)) {
            Subject subject = new Subject();
            subject.setSubjectName(attributes.getValue(StrategyUtils.TITLE));
            try {
                subject.setMark(Integer.parseInt(attributes.getValue(StrategyUtils.MARK)));
            } catch (Exception e) {
                e.printStackTrace();
            }

            student.addSubject(subject);

            return;
        }

        if (qName.equalsIgnoreCase(StrategyUtils.AVERAGE)) {
            isAverage = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (!isAverage) {
            return;
        }

        String average = new String(ch, start, length);
        student.setAverage(Double.parseDouble(average));
        isAverage = false;
    }

}

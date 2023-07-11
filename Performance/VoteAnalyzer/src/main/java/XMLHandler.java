import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class XMLHandler extends DefaultHandler {

    private SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    Voter voter;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("voter")){
            try {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);

                DBConnection.countVoter(voter.getName(),birthDayFormat.format(voter.getBirthDay()));

            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

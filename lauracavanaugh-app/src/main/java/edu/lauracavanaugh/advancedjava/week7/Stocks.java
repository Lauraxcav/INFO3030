package edu.lauracavanaugh.advancedjava.week7;

import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.util.InvalidXMLException;
import com.origamisoftware.teach.advanced.util.XMLUtils;
import com.origamisoftware.teach.advanced.xml.XMLDomainObject;
import edu.lauracavanaugh.advancedjava.week7.model.Stocks_Quotes;
import edu.lauracavanaugh.advancedjava.week7.services.StockORMService;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stocks")
public class Stocks implements XMLDomainObject {

    public static String SCHEMA_RESOURCE = "/xml/stock_info.xsd";
    public static String XML_RESOURCE = "/xml/stock_info.xml";
    public static StockORMService DB_SERVICE = ServiceFactory.getStockORMService();


    @XmlElement(name="stock")
    protected List<Stock> stocks = null;

    public List<Stock> getStocks() {
        if (stocks == null) {
            stocks = new ArrayList<Stock>();
        }
        return this.stocks;
    }
    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public static Stocks unmarshalXmlToObject() {

        JAXBContext jaxbContext;
        Stocks stocksObject = null;

        try {
            //Get JAXBContext
            jaxbContext = JAXBContext.newInstance(Stocks.class);

            //Create Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //Setup schema validator
            InputStream schemaResourceAsStream = Stocks.class.getResourceAsStream(Stocks.SCHEMA_RESOURCE);
            Source schemaSource = new StreamSource(schemaResourceAsStream);
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema stockSchema = sf.newSchema(schemaSource);
            jaxbUnmarshaller.setSchema(stockSchema);

            //Unmarshal xml file
            InputStream xmlResourceAsString = Stocks.class.getResourceAsStream(Stocks.XML_RESOURCE);

            Source xmlSource = new StreamSource(xmlResourceAsString);
            stocksObject = (Stocks) jaxbUnmarshaller.unmarshal(xmlSource);

        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
        return stocksObject;
    }

    /*
    Originally this was an instance method; Stocks should know how to unmarshal itself into Stocks.
    But the return value is Stocks, not a List<Stock> so that wasn't working too well.
     */
    public static Stocks unmarshalXmlToObjectOtherWay() {

        Stocks stocksObject = null;
        try {
            //get xmlInstance
            InputStream xmlResourceAsString = Stocks.class.getResourceAsStream(XML_RESOURCE);
            String xmlInstance = new BufferedReader(new InputStreamReader(xmlResourceAsString))
                    .lines().collect(Collectors.joining("\n"));

            stocksObject = XMLUtils.unmarshall(xmlInstance,Stocks.class,SCHEMA_RESOURCE);

        } catch ( InvalidXMLException e) {
            e.printStackTrace();
        }
        return stocksObject;
    }

    /**
     * add a Stocks object (list of Stock) to the mysql database
     * @param stocks
     */
    public static void addOrUpdateDatabase(Stocks stocks) {

        List<Stock> stocksList = stocks.getStocks();

        for (Stock stock : stocksList) {
            // basically have to convert Stock to a Stocks_Quotes object, then add/update the database
            Stocks_Quotes ormQuote = new Stocks_Quotes(stock.getSymbol(), stock.getPrice(), stock.getTime());
            DB_SERVICE.addOrUpdateQuote(ormQuote);
        }
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "stocks=" + stocks +
                '}';
    }
}

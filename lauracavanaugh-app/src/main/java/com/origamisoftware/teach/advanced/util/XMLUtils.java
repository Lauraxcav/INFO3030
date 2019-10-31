package com.origamisoftware.teach.advanced.util;

import com.origamisoftware.teach.advanced.xml.XMLDomainObject;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

/**
 * A collection of helper methods for marshaling and unmarshaling XML instances.
 */
public class XMLUtils {

        /**
         * Put the provided XML String into the specified XML Domain Object using JAXB without using
         * schema validation.
         *
         * @param xmlInstance an XML instance that matched the XML Domain object specified by T
         * @param T           a XML Domain object class which corresponds the XML instance
         * @return XML Domain Object of type T populated with values in the provided String.
         * @throws InvalidXMLException if the provided  xmlInstance cannot be successfully parsed.

         */
        public static  <T extends XMLDomainObject> T unmarshall(String xmlInstance, Class T)
                throws InvalidXMLException {
            T returnValue;
            try {
                Unmarshaller unmarshaller = createUnmarshaller(T);
                returnValue = (T) unmarshaller.unmarshal(new StringReader(xmlInstance));
            } catch (JAXBException e) {
                throw new InvalidXMLException("JAXBException issue: " +e.getMessage(),e);
            }
            return returnValue;
        }

        /**
         * Put the provided XML String into the specified XML Domain Object using JAXB using
         * schema validation.
         *
         * @param xmlInstance an XML instance that matched the XML Domain object specified by T
         * @param T           a XML Domain object class which corresponds the XML instance
         * @param schemaName  the name of the .xsd schema which must be on the classpath - used for validation.
         * @return XML Domain Object of type T populated with values in the provided String.
         * @throws InvalidXMLException if the provided  xmlInstance cannot be successfully parsed.
         */
        public static <T extends XMLDomainObject> T unmarshall(String xmlInstance, Class T, String schemaName)
                throws InvalidXMLException {

            T returnValue;
            try {
                InputStream resourceAsStream = XMLUtils.class.getResourceAsStream(schemaName);
                Source schemaSource = new StreamSource(resourceAsStream);
                if (resourceAsStream == null) {
                    throw new IllegalStateException("Schema: " + schemaName + " on classpath. " +
                            "Could not validate input XML");
                }
                SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = schemaFactory.newSchema(schemaSource);
                Unmarshaller unmarshaller = createUnmarshaller(T);
                unmarshaller.setSchema(schema);

                returnValue = (T) unmarshaller.unmarshal(new StringReader(xmlInstance));
            } catch (JAXBException | SAXException e) {
                throw new InvalidXMLException(e.getMessage(),e);
            }
            return returnValue;
        }

    /**
     * Serializes the domainClass into an XML instance which is returned as a String.
     * @param domainClass the XML model class.
     * @return a String which is a valid XML instance for the domain class provided.
     * @throws InvalidXMLException is the object can't be parsed into XML.
     */
    public static String marshall(XMLDomainObject domainClass) throws InvalidXMLException {
       try {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JAXBContext context = JAXBContext.newInstance(domainClass.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(domainClass, byteArrayOutputStream);
        return byteArrayOutputStream.toString();
    } catch (JAXBException e) {
        throw new InvalidXMLException(e.getMessage(),e);
    }

    }



        private static Unmarshaller createUnmarshaller(Class T) throws JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(T);
            return jaxbContext.createUnmarshaller();
        }

}

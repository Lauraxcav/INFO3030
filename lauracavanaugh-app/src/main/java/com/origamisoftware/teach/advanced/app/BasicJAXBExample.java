package com.origamisoftware.teach.advanced.app;

import com.origamisoftware.teach.advanced.xml.Family;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * A basic app that shows how to marshall and unmarshal XML instances.
 */
public class BasicJAXBExample {

    private static String xmlInstance ="<family>\n" +
            "    <father age=\"40\">Fred</father>\n" +
            "    <mother age=\"40\">Sally</mother>\n" +
            "    <kids>\n" +
            "        <child age=\"11\" grade=\"5\">Peter</child>\n" +
            "        <child age=\"15\" grade=\"9\">Bill</child>\n" +
            "        <child age=\"09\" grade=\"3\">Sally</child>\n" +
            "    </kids>\n" +
            "</family>";


    public static void main(String[] args) throws JAXBException {

        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Family.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Family family = (Family) unmarshaller.unmarshal(new StringReader(xmlInstance));
        System.out.println(family.toString());

        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Family.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(family, System.out);

    }
}

package tasks.lesson_16.by.yurachel.service;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Valid {

    public final static String XML_FILE_NAME = "Devices.xml";
    public final static String XSD_FILE_NAME = "Devices.xsd";

    // Validator.

    public static boolean validateXML() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(XSD_FILE_NAME));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(XML_FILE_NAME)));
        } catch (IOException | SAXException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    //SAXParser

    public static void SAXParser() {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            DefaultHandler handler = new Handler();
            saxParser.parse(XML_FILE_NAME, handler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //StaxParser.

    public static void StAXParse() {
        XMLStreamReader reader = null;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            reader = factory.createXMLStreamReader(new FileInputStream(XML_FILE_NAME));
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    System.out.println("<" + reader.getLocalName() + ">");
                    if (reader.getAttributeCount() > 0) {
                        System.out.println(" " + reader.getAttributeValue(0));
                    }

                } else if (reader.isEndElement()) {
                    System.out.println("<\\" + reader.getLocalName() + ">");
                } else if (reader.hasText() && reader.getText().trim().length() > 0) {
                    System.out.println(reader.getText());
                }
            }
        } catch (IOException | XMLStreamException e) {
            System.err.println(e.getMessage());
        } finally {
            if (Objects.nonNull(reader)) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }


    // DOM parser.

    public static void DOMParser() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(XML_FILE_NAME);

            Node root = document.getDocumentElement();

            System.out.println("Devices: " + "\n");

            NodeList devices = root.getChildNodes();


            for (int i = 0; i < devices.getLength(); i++) {  // Пробегаем по Devices.
                Node device = devices.item(i);
                if (device.getNodeType() != Node.TEXT_NODE) {
                    System.out.println(device.getNodeName() + ":" + device.getAttributes().item(0).getNodeValue());
                    NodeList deviceProperties = device.getChildNodes();

                    for (int j = 0; j < deviceProperties.getLength(); j++) {   // Пробегаем по Device.
                        Node deviceProp = deviceProperties.item(j);
                        if (deviceProp.getNodeType() != Node.TEXT_NODE) {

                            if (deviceProp.getChildNodes().getLength() > 1) {  // Если есть комплексный тип.
                                System.out.println(deviceProp.getNodeName() + ":");
                                NodeList typeChild = deviceProp.getChildNodes();
                                for (int k = 0; k < typeChild.getLength(); k++) {
                                    Node type = typeChild.item(k);
                                    if (type.getNodeType() != Node.TEXT_NODE) {
                                        System.out.println(" " + type.getNodeName() + ":" + type.getChildNodes().item(0).getTextContent());
                                    }
                                }

                            } else if (deviceProp.hasAttributes()) {  // Если есть атрибуты.
                                System.out.println(deviceProp.getNodeName() + ":" + deviceProp.getAttributes().item(0).getNodeValue() + " "
                                        + deviceProp.getChildNodes().item(0).getTextContent());

                            } else {
                                System.out.println(deviceProp.getNodeName() + ":" + deviceProp.getChildNodes().item(0).getTextContent());

                            }
                        }
                    }
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

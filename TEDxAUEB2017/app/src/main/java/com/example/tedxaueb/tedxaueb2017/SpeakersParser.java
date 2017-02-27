package com.example.tedxaueb.tedxaueb2017;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import Helpers.MyXMLHandler;
import Models.Speaker;

/**
 * Created by tasos on 2/27/2017.
 */

public class SpeakersParser {

    public List<Speaker> getSpeakers(){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyXMLHandler handler = new MyXMLHandler();
            saxParser.parse(new File("/assets/SpeakersData.xml"), handler);
            return handler.getSpList();

        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
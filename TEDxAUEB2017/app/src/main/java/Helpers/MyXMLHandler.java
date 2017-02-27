package Helpers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import Models.Speaker;

/**
 * Created by tasos on 2/27/2017.
 */

public class MyXMLHandler extends DefaultHandler {
    private List<Speaker> spList = null;
    private Speaker sp=null;
    public List<Speaker> getSpList(){
        return spList;
    }
    boolean bBio = false;
    boolean bName = false;
    boolean bSBio = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException{
        if(qName.equalsIgnoreCase("Speaker")){
            String name = attributes.getValue("Name");
            String bio = attributes.getValue("Bio");
            String sbio = attributes.getValue("ShortBio");
            sp=new Speaker(name,bio,sbio);
            if(spList==null)
                spList=new ArrayList<Speaker>();
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equalsIgnoreCase("Speaker")){
            spList.add(sp);
        }
    }
}

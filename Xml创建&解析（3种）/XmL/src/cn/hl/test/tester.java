package cn.hl.test;

import cn.hl.dom.Dom;
import cn.hl.dom4j.Dom4J;
import cn.hl.jdom.JDom;
import org.dom4j.DocumentException;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class tester {
    public static void main(String[] args) {
        String path = "e:\\User.xml";
        //testDom(path);
        //testJDom(path);
        testDom4J(path);
    }

    private static void testDom4J(String path) {
        Dom4J dom = new Dom4J();
        //dom.write(path);
        //dom.read(path);
        try {
            dom.Xpath(path);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void testJDom(String path) {
        JDom jd = new JDom();
        try {
            //jd.write(path);
            try {
                jd.read(path);
            } catch (JDOMException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testDom(String path) {
        Dom d = new Dom();
        try {
            //d.write(path);
            d.read(path);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

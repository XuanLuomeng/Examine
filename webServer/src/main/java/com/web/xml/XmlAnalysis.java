package com.web.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 解析器
 * 获取url对应的包名，以供反射
 */
public class XmlAnalysis {
    private Map<String, String> servlet;

    public XmlAnalysis() {
        servlet = new HashMap<>();
        Element root = getRootElement();
        // 枚举根节点下所有子节点
        for (Iterator ie = root.elementIterator(); ie.hasNext(); ) {
            Element element = (Element) ie.next();

            // 枚举当前节点下所有子节点
            List nodes = element.elements("servlet-name");
            List nodes1 = element.elements("servlet-class");
            Iterator ies = nodes.iterator();
            Iterator ies1 = nodes1.iterator();
            //一般情况下url名与包名数都是一致的，所以hasNest只用其中一个
            while (ies.hasNext()) {
                Element elementSon = (Element) ies.next();
                Element elementSon1 = (Element) ies1.next();
                //将url作为键，包名作为值传给map
                this.servlet.put(elementSon.getText(),elementSon1.getText());
            }
        }
    }


    public Element getRootElement() {
        return getDocument().getRootElement();
    }

    public Document getDocument() {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read("src/main/java/com/web/xml/web.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public Map<String, String> getServlet() {
        return servlet;
    }
}



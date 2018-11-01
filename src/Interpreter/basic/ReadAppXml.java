package Interpreter.basic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadAppXml {

    public void read(String filePathName)  throws Exception {
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 得到一个表示xml文档的Document 对象
        doc = builder.parse(filePathName);
        //去掉xml中作为格式化的内容空白
        doc.normalize();


        NodeList jdbc = doc.getElementsByTagName("jdbc");
        NodeList driverClassNode = ((Element)jdbc.item(0)).getElementsByTagName("driver-class");
        String driverClass = driverClassNode.item(0).getFirstChild().getNodeValue();
        System.out.println("driverClass == " + driverClass);
        NodeList  urlNode = ((Element)jdbc.item(0)).getElementsByTagName("url");
        String url = urlNode.item(0).getFirstChild().getNodeValue();
        System.out.println("url == " + url);


        NodeList userNode = ((Element)jdbc.item(0)).getElementsByTagName("user");

        String user = userNode.item(0).getFirstChild().getNodeValue();
        System.out.println("user == " +user);

        //获取application-xml
        NodeList  appliationXmlNode = doc.getElementsByTagName("application-xml");
        String applicationXml = appliationXmlNode.item(0).getFirstChild().getNodeValue();
        System.out.println("applicationXml ==" + applicationXml);


    }
}

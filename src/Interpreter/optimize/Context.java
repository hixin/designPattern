package Interpreter.optimize;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Context {

    private Element preEle = null;
    private Document document = null;

    public Context(String filePathName) throws Exception  {
        this.document = XmlUtil.getRoot(filePathName);
    }

    public void reInit() {
        preEle = null;
    }

    /**
     * 根据父元素和当前元素的名称来获取当前的元素
     * @param pEle
     * @param eleName
     * @return
     */
    public Element getNowEle(Element pEle, String eleName) {
        NodeList tempNodeList = pEle.getChildNodes();
        for (int i = 0; i<tempNodeList.getLength(); i++) {
            if (tempNodeList.item(i)  instanceof  Element) {
                Element nowEle = (Element)tempNodeList.item(i);
                if(nowEle.getTagName().equals(eleName)) {
                    return nowEle;
                }
            }
        }

        return null;
    }


    public Element getPreEle() {
        return preEle;
    }

    public  void setPreEle(Element preEle) {
        this.preEle = preEle;
    }

    public Document getDocument() {
        return document;
    }

}

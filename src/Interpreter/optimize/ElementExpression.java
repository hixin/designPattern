package Interpreter.optimize;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 元素作为非终结符对应的解释器
 */
public class ElementExpression extends ReadXmlExpression {
    private Collection<ReadXmlExpression> eles = new ArrayList<>();

    private String eleName = "";

    public  ElementExpression(String eleName) {
        this.eleName = eleName;
    }

    public  boolean addEle(ReadXmlExpression ele) {
        this.eles.add(ele);
        return true;
    }

    public boolean removeEle(ReadXmlExpression ele) {
        this.eles.remove(ele);
        return  true;
    }

    @Override
    public String[] interpret(Context c) {
        Element pEle = c.getPreEle();
        if(pEle == null) {
            c.setPreEle(c.getDocument().getDocumentElement());
        }else {
            Element nowEle = c.getNowEle(pEle, eleName);
            c.setPreEle(nowEle);
        }


        String[] ss = null;
        for (ReadXmlExpression ele : eles) {
            ss = ele.interpret(c);
        }

        return ss;
    }


}

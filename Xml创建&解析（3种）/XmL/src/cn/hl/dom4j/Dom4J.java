package cn.hl.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.sql.rowset.spi.XmlWriter;
import java.io.*;
import java.util.Iterator;

/**
 * Dom4J方式解析Xml
 *      DocumentHelper      :提供获取Document对象的相关方法
 *      XMLWriter           ：将文档对象输出到文件
 *
 *      Dom4J提供了一组开放、高效的API来操作XML，Dom4J是开源的，简便方便而且效率非常高。Sun公司的部分底层代码中也用到了Dom4j.如Jaxm
 */
public class Dom4J {
    /**
     * 使用Dom4j方式解析XML生成xml文档
     * @param path
     * @throws IOException
     */
    public void write(String path) throws IOException {
        //1.通过DocumentHelper对象构建Document对象
        Document doc = DocumentHelper.createDocument();

        //2.创建节点
        //创建根节点
        Element root  = doc.addElement("User");

        //创建name子节点
        Element name = root.addElement("Name");
        name.setText("Tom");

        //创建age子节点

        Element age = root.addElement("Age");
        age.setText("24");

        //3.创建Xml文件
        Writer writer = new PrintWriter(path);
        //创建XMLWriter对象
        XMLWriter xw = new XMLWriter(writer);
        //通过XMLWriter生成xml文档
        xw.write(doc);
        writer.close();
        System.out.println("Dom4J方式创建成功。。。");
    }

    /**
     * Dom4J方式读取Xml文件
     * @param path
     * @throws DocumentException
     */
    public void read(String path) throws DocumentException {
        //1.获取SaxReader对象
        SAXReader reader = new SAXReader();

        //2.获取Document对象
        Document doc = reader.read(new File(path));

        //3.读取节点
        //1）获取根节点对象
        Element root =doc.getRootElement();

        //2)获取根节点的子节点
        Iterator<Element> iterator = root.elementIterator();
        //通过迭代器遍历节点集合
        while (iterator.hasNext()){
            //获取节点集合
            Element node = iterator.next();
            System.out.println(node.getName()+"|"+node.getText());
        }
    }

    /**
     * 使用Xpath方式读取节点内容
     *      Dom4j方式同样支持Xpath
     *      需要导入jaxen-1.1-beta-6.jar
     * @param path
     * @throws DocumentException
     */
    public void Xpath(String path) throws DocumentException {
        //1.获取SAXReader对象
        SAXReader reader  = new SAXReader();
        //2.获取Document对象
        Document doc = reader.read(new File(path));
        //3.通过Xpath获取节点对象
        Node node = doc.selectSingleNode("/User/Name");
        //4.操作节点

        System.out.println(node.getName() + " | " + node.getText());
    }



}

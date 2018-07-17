package cn.hl.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Dom方式解析
 *      Dom是一组API,提供了用于操作XML文档的相关接口
 *
 *   缺点：
 *      一次性将文档加载到内存中。比较浪费资源。
 *   适用：
 *      频繁读取xml内容的情况下适用
 *
 *
 *      DocumentBuilderFactory   ：获取一个Dom文档解析器，通过DocumentBuilderFactory对象可以构建出DocumentBuilder
 *      DocumentBuilder          ：获取一个Dom文档对象
 *      Document                 ：Dom文档实例
 *      TransformerFactory       : 获取一个Transformer对象
 *      Transformer              : 转换器，将源树转为结果树
 *      DOMSourse                : 以内存中源树作为结果源
 *
 */
public class Dom {
    /**
     * 使用Dom方式创建Xml文件
     * @param path
     * @throws ParserConfigurationException
     * @throws TransformerException
     * @throws FileNotFoundException
     */
   public void write(String path) throws ParserConfigurationException, TransformerException, FileNotFoundException {
       //1、定义一个DocumentDuilderFactory对象
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

       //2、获取DocumentBuilder对象
       DocumentBuilder builder = factory.newDocumentBuilder();
       //3、获取dom对象实例
       Document doc = builder.newDocument();

       //4、创建元素
       //1)、创建根元素
       Element root = doc.createElement("Users");

       //2)、创建name元素
       //a、创建节点元素
       Element name = doc.createElement("Name");
       //b、为节点元素添加内容
       name.appendChild(doc.createTextNode("Mike"));
       //c、将节点元素挂接到指定节点下
       root.appendChild(name);

       //3)、创建age元素
       Element age = doc.createElement("Age");
       age.appendChild(doc.createTextNode("20"));
       root.appendChild(age);

       //4)、根节点挂接到文档对象
       doc.appendChild(root);

       //5、创建TransformerFactory对象
       TransformerFactory formerFactory= TransformerFactory.newInstance();

       //6、创建Transformer对象
       Transformer former = formerFactory.newTransformer();
       //设置文件属性
       former.setOutputProperty("encoding", "ascii");

       //7、构建DOMSource对象
       DOMSource dom = new DOMSource(doc);

       //8、创建StreamResult对象
       PrintWriter writer= new PrintWriter(new File(path));
       StreamResult result = new StreamResult(writer);

       //9、将Result源转为结果
       former.transform(dom, result);
       System.out.println("Dom方式创建完成......");
   }

    /**
     * 以Dom方式读取Xml文档的内容
     * @param path
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
   public void read(String path) throws IOException, SAXException, ParserConfigurationException {
       //1.创建DocumentBuilderBuilderFactory
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

       //2.创建DocumentBuilder对象
       DocumentBuilder builder = factory.newDocumentBuilder();

       //3.创建文档对象
       //通过Builder对象的parse方法将文件转换并加载到内存中
       Document doc = builder.parse(path);

       //4.解析Xml文档
       NodeList nodes = doc.getChildNodes();

       //判断是否记载到节点
       if(nodes.getLength()<1) return;

       //获取根节点的所有子节点
       //node.item(0)---获取根节点
       NodeList list = nodes.item(0).getChildNodes();
       for (int i = 0;i<list.getLength();i++){
           System.out.println(list.item(i).getNodeName() +"|"+ list.item(i).getTextContent());
       }


   }


}

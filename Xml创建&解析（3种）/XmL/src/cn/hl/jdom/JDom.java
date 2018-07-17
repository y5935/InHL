package cn.hl.jdom;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * JDom方式解析Xml文档内容
 *      Document        :代表 Xml文档对象
 *      Format          :Xml文档格式化对象，可以对文档内容进行格式化
 *      XMLOutputter    :文档输出对象
 *
 * 概述
 *      Dom及Sax方式代码过长，所以在Dom和Sax基础上发展出JDom解析方式。所以说JDom是以Dom和Sax为基础进行实现的。
 * 优点
 *      代码量较少，更加清晰，简洁，更符合80-20原则
 * 适用
 *      代码量较小的解析读取过程
 *
 */
public class JDom {
    /**
     * JDom方式创建Xml文档
     * @param path
     * @throws IOException
     */
   public void  write(String path) throws IOException {
       //1.创建Document对象
       Document doc  = new Document();

       //2.创建element对象
       //1）创建根节点对象
       Element root = new Element("User");
       //将根节点添加到文档中
       doc.addContent(root);

       //2)创建子节点对象
       //a.创建节点对象
       Element name = new Element("name");
       //b.设置节点的文本内容
       name.setText("Jone");
       //将子节点添加到root根节点下
       root.addContent(name);

       Element age = new Element("Age");
       age.setText("23");
       root.addContent(age);

       //3.获取Format对象
       Format formatter = Format.getPrettyFormat();
       //设置编码格式
       formatter.setEncoding("UTF-8");
       //设置缩进距离（一般网络环境下不建议使用---缩进也是字符）
       formatter.setIndent("   ");

       //4.创建XMLOutputter对象
       //通过该对象将内容进行输出
       XMLOutputter outputter = new XMLOutputter(formatter);
       outputter.output(doc,new FileOutputStream(path));

       System.out.println("JDom方式创建结束.....");
   }

    /**
     * 以JDom方式解析Xml文档
     * @param path
     * @throws JDOMException
     * @throws IOException
     */
   public void read(String path) throws JDOMException, IOException {
       //1.构建SAXBuilder对象
       SAXBuilder builder = new SAXBuilder();

       //2.通过SaxBuilder对象获取Document对象
       Document doc = builder.build(new File(path));

       //3.解析xml文档
       //获取根节点元素
       Element root  = doc.getRootElement();

       //4.获取所有子节点
       List<Element> list  = root.getChildren();

       //5.遍历所有子节点
       for (Element ele : list){
           System.out.println(ele.getName() +"|"+ele.getText());
       }
   }

}

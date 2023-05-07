import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Zhixiang Shang on 07.05.2023.
 */
public class parseSAX_add {
    public void parseSAX_add(String s) throws Exception{
        /**
         * 先读进来
         */
        //将xml文件转换成数据流
        InputStream is = parseSAX_add.class.getClassLoader().getResourceAsStream("PersonTable.xml");
        //生成SAX对象
        SAXReader sax = new SAXReader();
        //将数据流通过sax转换成文档对象
        Document doc = sax.read(is);
        //获取文档中的根节点
        Element root = doc.getRootElement();
        /**
         * 创建数据
         */
        //创建元素(节点)
        Element person = root.addElement("person");

        Element id = person.addElement("id");
        Element name = person.addElement("name");
        Element age = person.addElement("age");

        id.setText("3");
        name.setText("c");
        age.setText("32");

        /**
         * 写入到xml文件中
         */
        File file = new File("PersonTable.xml");
        FileOutputStream out = new FileOutputStream(file);
        OutputFormat format = new OutputFormat("\t",true,"UTF-8");
        //生成写如对象
        XMLWriter xw = new XMLWriter(out,format);
        //将整个文档写入到xml中
        xw.write(doc);
    }
}

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 查询数据
 * Created by Zhixiang Shang on 07.05.2023.
 */
public class parseSAX{
    public void parseSAX() throws Exception {
        //将xml文件转换成数据流
        InputStream is = parseSAX.class.getClassLoader().getResourceAsStream("PersonTable.xml");
        //生成SAX对象
        SAXReader sax = new SAXReader();
        //获得文档对象，将数据流通过SAX获取文档对象
        Document doc = sax.read(is);
        //获取根元素
        Element root = doc.getRootElement();


        /**
         * 查询数据需要遍历，非常占用内存
         */
        //获得根元素下的所有子元素
        List<Element> list = root.elements();
        System.out.println("文档长度为" + list.size());
        //取值不取属性
        list.forEach(System.out::println);
        for (Element e1: list) {
//            System.out.println(e1.getName());
            List<Element> list2 = e1.elements();
            for (Element e2:list2) {
                System.out.println(e2.getName()+":"+e2.getData());
            }
        }
        //取属性
        for (Element e3:list ) {
            Attribute country = e3.attribute("country");
            System.out.println("属性值：" + country.getValue());
        }

        /**
         *
         *改进办法Xpath
         * 看parseSAX_xpath.java文件
         */

    }
}
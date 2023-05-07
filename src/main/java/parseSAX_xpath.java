import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.Element;

import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Zhixiang Shang on 07.05.2023.
 */
public class parseSAX_xpath {
    public void parseSAX_xpath() throws Exception{
        InputStream is = parseSAX_xpath.class.getClassLoader().getResourceAsStream("PersonTable.xml");
        SAXReader sax = new SAXReader();
        Document doc = sax.read(is);
        Element root = doc.getRootElement();

        System.out.println("--------------------------获得所有人员-------------------------");
        List<Node> list = root.selectNodes("person");
        list.forEach(System.out::println);
        System.out.println("-------------------------获得所有名字--------------------------");
        List<Node> list1 = root.selectNodes("person/name");
        list.forEach(System.out::println);
        System.out.println("-------------------------忽略层级和位置--------------------------");
        List<Node> list2 = root.selectNodes("//name");
        list2.forEach(s->System.out.println(s.getStringValue()));
        System.out.println("-------------------------指定某人的信息--------------------------");
        List<Node> list3 = root.selectNodes("person[1]");
        list3.forEach(s1->System.out.println(s1.getStringValue()));
        System.out.println("-------------------------获取前两个人的姓名--------------------------");
        List<Node> list4 = root.selectNodes("person[position()<=2]/name");
        list4.forEach(s1->System.out.println(s1.getStringValue()));
        System.out.println("-------------------------获取最后一个人的姓名--------------------------");
        List<Node> list5 = root.selectNodes("person[last()]/name");
        list5.forEach(s1->System.out.println(s1.getStringValue()));
        System.out.println("-------------------------获取带有属性country的人的姓名--------------------------");
        List<Node> list6 = root.selectNodes("person[@country]/name");
        list6.forEach(s1->System.out.println(s1.getStringValue()));
        System.out.println("-------------------------获取属性工作为chairman的人的id--------------------------");
        List<Node> list7 = root.selectNodes("person[@job='chairman']/id");
        list7.forEach(s1->System.out.println(s1.getStringValue()));
        System.out.println("-------------------------获取年龄超过15岁的人--------------------------");
        List<Node> list8 = root.selectNodes("person[age>15]");
        list8.forEach(s1->System.out.println(s1.getStringValue()));
        System.out.println("-------------------------获取xml中倒数第二个人--------------------------");
        List<Node> list9 = root.selectNodes("person[last()-1]");
        list9.forEach(s1->System.out.println(s1.getStringValue()));
    }
}

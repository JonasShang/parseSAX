/**
 * @Author Zhixiang Shang
 * @Date 09.05.2023 17:57
 * @Version 1.0
 */
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MyHandler extends DefaultHandler {
    private boolean bAuthor;
    private boolean bTitle;
    private boolean bGenre;
    private boolean bPrice;
    private boolean bPublishDate;
    private boolean bDescription;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            String bookId = attributes.getValue("id");
            System.out.println("Book ID: " + bookId);
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
        } else if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("genre")) {
            bGenre = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        } else if (qName.equalsIgnoreCase("publish_date")) {
            bPublishDate = true;
        } else if (qName.equalsIgnoreCase("description")) {
            bDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("------------------------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthor) {
            System.out.println("Author: " + new String(ch, start, length));
            //使用 new String(ch, start, length) 将 ch 数组中的字符内容转换成字符串，并输出该字符串
            bAuthor = false;
        } else if (bTitle) {
            System.out.println("Title: " + new String(ch, start, length));
            bTitle = false;
        } else if (bGenre) {
            System.out.println("Genre: " + new String(ch, start, length));
            bGenre = false;
        } else if (bPrice) {
            System.out.println("Price: " + new String(ch, start, length));
            bPrice = false;
        } else if (bPublishDate) {
            System.out.println("Publish Date: " + new String(ch, start, length));
            bPublishDate = false;
        } else if (bDescription) {
            System.out.println("Description: " + new String(ch, start, length));
            bDescription = false;
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建 SAXParserFactory 和 SAXParser 对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        // 创建处理器对象
        MyHandler handler = new MyHandler();

        // 解析 XML 文件
        saxParser.parse("E:\\parseSAX\\src\\main\\java\\FileMyHandler.xml", handler);
    }
}

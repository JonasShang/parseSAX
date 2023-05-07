/**
 * Created by Zhixiang Shang on 07.05.2023.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        parseSAX psGet = new parseSAX();
        parseSAX_xpath psGet_xpath = new parseSAX_xpath();
        parseSAX_add psPOST = new parseSAX_add();

//        psGet.parseSAX();
        psGet_xpath.parseSAX_xpath();
//        psPOST.parseSAX_add("");
    }
}

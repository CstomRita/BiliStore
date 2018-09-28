import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:35 2018/9/28
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Test {


    public static void TestDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        TestDateTime();
    }

}

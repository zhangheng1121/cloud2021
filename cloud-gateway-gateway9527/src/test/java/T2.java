import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/22
 * @Version 1.0
 */
@SpringBootTest
public class T2 {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();  // 默认时区
        System.out.println(zonedDateTime);
    }

}

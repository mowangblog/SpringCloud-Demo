import java.time.ZonedDateTime;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/11/01 15:42
 **/
public class T2
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

        //2021-11-01T15:42:46.966+08:00[Asia/Shanghai]
    }
}



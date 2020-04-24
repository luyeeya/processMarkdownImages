package club.banyuan;

import java.util.regex.Pattern;

/**
 * 常量类
 *
 * @author ly
 */
public class Const {

    public static final String FILE_SUFFIX_MD = ".md";

    /**
     * OSS验证身份信息
     */
    public static final String END_POINT = "http://******.aliyuncs.com";
    public static final String ACCESS_KEY_ID = "******";
    public static final String ACCESS_KEY_SECRET = "******";
    public static final String BUCKET_NAME = "******";

    /**
     * OSS链接通用前缀
     */
    public static final String LINK_PREFIX = "http://" + BUCKET_NAME + "." + END_POINT.substring(END_POINT.lastIndexOf('/') + 1);

    /**
     * 匹配Markdown图片的正则
     */
    public static final Pattern MD_IMG_PATTERN = Pattern.compile("!\\[.*?\\]\\((.*?)\\)");

    /**
     * 用于获得文件名的正则
     */
    public static final String MD_IMG_PATTERN_SPEC = "(!\\[.*?\\])\\(.*/(.*?)\\)";

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36";


}

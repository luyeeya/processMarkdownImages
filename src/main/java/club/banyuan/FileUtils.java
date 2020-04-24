package club.banyuan;

import java.nio.file.Path;

/**
 * 文件操作工具类
 *
 * @author ly
 */
public class FileUtils {

    public static boolean isMarkdownFile(Path file) {
        return file.getFileName().toString().endsWith(Const.FILE_SUFFIX_MD);
    }

}

package club.banyuan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

/**
 * 替换Markdown文件中的图片链接为Oss链接
 *
 * @author ly
 */
public class ReplaceImgLinks {

    public static List<String> replace(Path file, String parentDir) throws IOException {
        String newLinkPrefix = Const.LINK_PREFIX + "/" + parentDir;
        String oldFileName = file.getFileName().toString();
        String newFileName = oldFileName.replaceAll("(.*)" + Const.FILE_SUFFIX_MD, "$1-new" + Const.FILE_SUFFIX_MD);
        Path newFile = Files.createFile(Paths.get(file.getParent().toString(), newFileName));

        String oldContent = new String(Files.readAllBytes(file));
        List<String> linksToBeReplaced = getAllMatchedLinks(oldContent);
        String newContent = oldContent.replaceAll(Const.MD_IMG_PATTERN_SPEC, "$1(" + newLinkPrefix + "$2)");
        Files.write(newFile, newContent.getBytes());

        return linksToBeReplaced;
    }

    /**
     * 获得Markdown文件中所有匹配的图片链接
     *
     * @param oldContent
     * @return
     */
    private static List<String> getAllMatchedLinks(String oldContent) {
        List<String> linksToBeReplaced = new ArrayList<>();
        Matcher matcher = Const.MD_IMG_PATTERN.matcher(oldContent);
        while (matcher.find()) {
            linksToBeReplaced.add(matcher.group(1));
        }
        return linksToBeReplaced;
    }

}

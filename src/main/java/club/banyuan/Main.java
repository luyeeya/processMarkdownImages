package club.banyuan;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 执行类：替换Markdown文件中图片链接并上传到OSS
 *
 * @author ly
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String path = args[0];
        String ossParentDir = args[1];

        OSS ossClient = new OSSClientBuilder().build(Const.END_POINT, Const.ACCESS_KEY_ID, Const.ACCESS_KEY_SECRET);
        try {
            Path dirOrFile = Paths.get(path);
            if (!Files.isDirectory(dirOrFile)) {
                replaceLinksAndUpload(ossClient, ossParentDir, dirOrFile);
                return;
            }
            List<Path> files = Files.list(dirOrFile).filter(Files::isRegularFile).filter(FileUtils::isMarkdownFile).collect(Collectors.toList());
            for (Path file : files) {
                replaceLinksAndUpload(ossClient, ossParentDir, file);
            }
        } finally {
            ossClient.shutdown();
        }
    }

    private static void replaceLinksAndUpload(OSS ossClient, String parentDir, Path dirOrFile) throws IOException {
        List<String> linksToBeReplaced = ReplaceImgLinks.replace(dirOrFile, parentDir);
        for (String link : linksToBeReplaced) {
            UploadImgToOss.upload(ossClient, link, parentDir);
        }
    }

}

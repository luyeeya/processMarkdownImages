package club.banyuan;

import com.aliyun.oss.OSS;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 通过url上传文件到OSS
 *
 * @author ly
 */
public class UploadImgToOss {

    public static void upload(OSS ossClient, String link, String parentDir) {
        String fileName = link.substring(link.lastIndexOf('/') + 1);
        String fileKey = parentDir + fileName;

        InputStream inputStream;
        try {
            URLConnection urlConnection = new URL(link).openConnection();
            urlConnection.addRequestProperty("User-Agent", Const.USER_AGENT);
            inputStream = urlConnection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ossClient.putObject(Const.BUCKET_NAME, fileKey, inputStream);
        System.out.println("Object：" + fileName + " 存入OSS成功。地址为：\n" + Const.LINK_PREFIX + "/" + fileKey);
    }

}

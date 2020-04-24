# 将Markdown文件中的图片上传到阿里云OSS，并替换文件中对应的链接

## 如何运行

- 使用阿里云OSS给的信息修改Const类中的 END_POINT、ACCESS_KEY_ID、ACCESS_KEY_SECRET和BUCKET_NAME

- `mvn clean package`

- `java -jar target/processmarkdownfiles-1.0-SNAPSHOT.jar $localFileOrDirectory $ossDirectory(以'/'结尾，开头无'/')`
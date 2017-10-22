package test;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;

import java.io.*;

/**
 * Created by guojun on 2015/11/26.
 */
public class OssClientDemo {

//    static String accessKeyId = "IshFU1znVG6MCqSI";
//    static String accessKeySecret = "nKWHMra4oaSeVL0BEQVd1LFPj4tv65";
//    static String accessKeyId = "tPeyhzjCMDqrCOyQ";//"IshFU1znVG6MCqSI";
//    static String accessKeySecret = "vIFFrOA89jJXnosY8F0FxpUbEXdKj4";//"nKWHMra4oaSeVL0BEQVd1LFPj4tv65";
//
//    static String accessKeyId = "qbRlaFurdixehcmO";
//    static String accessKeySecret = "mXa6jFkKI0kOzAmRNeQKCbgL3ev6C0";

    static String accessKeyId = "dnWRUaTmg9s5QXI1";
    static String accessKeySecret = "Ax15OngHevYUL14hD3PYmtReFYw8uP";


    // 以为例
    static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    static String bucketName = "cjccpic";

    public static void main(String[] args) throws FileNotFoundException {
        // 初始化一个OSSClient
//        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 下面是一些调用代码...
//        ...
        String key = "123.jpg";
//        String filePath="d:/123.jpg";
//        putObject(bucketName, key, filePath);
        listObjects(bucketName);
//        deleteObject(bucketName,key);
//        deleteObjectAll(bucketName);
    }

    public static void putObject(String bucketName, String key, String filePath) throws FileNotFoundException {

        // 初始化OSSClient
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 获取指定文件的输入流
        File file = new File(filePath);
        InputStream content = new FileInputStream(file);

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(file.length());


        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, key, content, meta);

        // 打印ETag
        System.out.println(result.getETag());
    }

    public static void listObjects(String bucketName) {

        // 初始化OSSClient
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);

// List Objects
        ObjectListing listing = client.listObjects(listObjectsRequest);
        // 获取指定bucket下的所有Object信息
//        ObjectListing listing = client.listObjects(bucketName,"cjccpic/");


        // 遍历所有Object
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            System.out.println(objectSummary.getKey());
            System.out.println(objectSummary.getBucketName());
            System.out.println(objectSummary.getETag());
        }
    }

    public void getObject(String bucketName, String key) throws IOException {

        // 初始化OSSClient
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 获取Object，返回结果为OSSObject对象
        OSSObject object = client.getObject(bucketName, key);
        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();
        // 处理Object
//        ...
        // 关闭流
        objectContent.close();
    }

    public static void deleteObject(String bucketName, String key) {
        // 初始化OSSClient
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 删除Object
        client.deleteObject(bucketName, key);
    }


    public static void deleteObjectAll(String bucketName) {

        // 初始化OSSClient
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 获取指定bucket下的所有Object信息
        ObjectListing listing = client.listObjects(bucketName);

        // 遍历所有Object
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            // 删除Object
            client.deleteObject(bucketName, objectSummary.getKey());
        }
    }
}

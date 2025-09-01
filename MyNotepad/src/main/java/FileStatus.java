import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileStatus {

  public static File f = new File("untitled");
//这是一个静态变量，表思在当前目录下的一个untitled目录的file对象。如果当前path下不存在，则创建一个
  //获取文本文件中的全部内容，以utf-8编码返回字符串
  public static String getContent(File file) throws IOException {
    FileInputStream in = new FileInputStream(file);
    // 这是一个读文件对象
    byte[] fileContent = new byte[(int)file.length()];
    // 创建一个byte空数组，长度为文件内容长度。
    in.read(fileContent);
    in.close();
    return new String(fileContent, StandardCharsets.UTF_8);
  }

  //写入文本
  public static void setContent(File file, String s) throws IOException {
    FileWriter fw = new FileWriter(file);
    fw.write(s);
    fw.close();
  }
}

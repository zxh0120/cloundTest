import com.PrintSize;
import com.config.constants.table.IO;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
/*
 *音频文件、图片、歌曲，就用字节流
 * 中文（文本）的，用字符流好点
 */
public class TestIo {
    public  volatile  int a =1;

    public static void main(String[] args) throws Exception {
        testCharToByteIo();

        //testByteToCharIO();
        // String readerPath = "d:/io/111.log";
        //  System.out.println(readerPath.substring(readerPath.lastIndexOf("/"), readerPath.length()));
        // testByteIo();
        // testChar();
        //  File file= new File(readerPath);
        //  log.info("----{}",file.length());


    }

    /**
     * 读取文件内容输出到控制台
     *
     * @throws Exception
     */
    public static void testCharToByteIo() throws Exception {
        String readerPath = "d:/io/111.log";
        //读取文件内容输出到控制台
        OutputStream outputStream = System.out;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedReader = new BufferedReader(new FileReader(readerPath));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                // 输出到控制台
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }

        }

    }


    /*
     * 从控制台输入，将输入的文本写入文件
     *
     */
    public static void testByteToCharIO() throws Exception {
        String outPath = "d:/io/111.log";
        // 创建字节流对象 System.in 代表从控制台输入
        InputStream inputStream = System.in;
        // 创建字符流对象
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            // 实例化字符流对象 通过 InputStreamReader 将字节输入流转化成字符输入流
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new FileWriter(outPath));
            // 定义读取数据的行
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if ("exit".equals(line)) {
                    break;
                }
                // 将数据写入文件
                bufferedWriter.write(line);
                // 写入新的一行
                bufferedWriter.newLine();
                // 刷新数据缓冲
                bufferedWriter.flush();
            }
        } finally {
            if (bufferedReader != null) {
                bufferedWriter.close();
            }
            if (bufferedWriter != null) {
                bufferedReader.close();
            }
        }
    }

    public static void testChar() throws Exception {
        String readerPath = "d:/io/111.log";
        String writerPtah = IO.ptah + readerPath.substring(readerPath.lastIndexOf("/"), readerPath.length());
        System.out.println(writerPtah);
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new BufferedReader(new FileReader(new File(readerPath)));
            writer = new BufferedWriter(new FileWriter(new File(writerPtah)));
            char[] chars = new char[1024 * 1024 * 10];
            int len = 0;
            int writerSumChar = 0;
            while ((len = reader.read(chars)) != -1) {
                writerSumChar += len;
//                String s = new String(chars, 0, len);
//                System.out.println(s);
                writer.write(chars, 0, len);
                writer.flush();
            }
            log.info("字节{}", PrintSize.getNetFileSizeDescription(writerSumChar));

        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void testByteIo() throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String filePath = "d:/io/jdk1.8中文百度.CHM";
            String outPtah = IO.ptah + filePath.substring(filePath.lastIndexOf("/"), filePath.length());
            System.out.println(outPtah);
            inputStream = new BufferedInputStream(new FileInputStream(new File(filePath)));
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(outPtah)));
            byte[] bytes = new byte[1024 * 1024 * 10];
            int len = 0;
            int sumByte = 0;
            while ((len = inputStream.read(bytes, 0, bytes.length)) != -1) {
                sumByte = len + sumByte;
                //sumByte += len;
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            log.info("字节{}", PrintSize.getNetFileSizeDescription(sumByte));
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

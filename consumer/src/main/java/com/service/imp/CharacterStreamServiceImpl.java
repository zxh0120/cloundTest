package com.service.imp;

import com.IoSetting;
import com.PrintSize;
import com.service.CharacterStreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;

@Slf4j
@Service
public class CharacterStreamServiceImpl implements CharacterStreamService {
    @Resource
    private IoSetting ioSetting;

    @Override
    public void redAndWriteChar(String filePath) throws Exception {
        String writerPtah = ioSetting.getFilePath() + filePath.substring(filePath.lastIndexOf("/"), filePath.length());
        System.out.println(writerPtah);
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new BufferedReader(new FileReader(new File(filePath)));
            writer = new BufferedWriter(new FileWriter(new File(writerPtah)));
            char[] chars = new char[ioSetting.getCharSize()];
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

    @Override
    public void ioStreamStateChange(String filePath) throws Exception {
        //从控制台输入，将输入的文本写入文件
        byteToCharIO(filePath);
        //读取文件内容输出到控制台
        charToByteIo(filePath);
    }

    /**
     * 读取文件内容输出到控制台
     *
     * @throws Exception
     */
    public static void charToByteIo(String filePath) throws Exception {
        //读取文件内容输出到控制台
        OutputStream outputStream = System.out;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedReader = new BufferedReader(new FileReader(filePath));
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
    public void byteToCharIO(String filePath) throws Exception {
        // 创建字节流对象 System.in 代表从控制台输入
        InputStream inputStream = System.in;
        // 创建字符流对象
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            // 实例化字符流对象 通过 InputStreamReader 将字节输入流转化成字符输入流
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
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
}
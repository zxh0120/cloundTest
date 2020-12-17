package com.controller;


import com.IoSetting;
import com.service.ByteStreamService;
import com.service.CharacterStreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * 音频文件、图片、歌曲，就用字节流
 * 中文（文本）的，用字符流好点
 * <p>
 * io流转换
 * InputStreamReader 是字节流通向字符流的桥梁
 * BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 * <p>
 * OutputStreamWriter 是字符流通向字节流的桥梁
 * Writer out =new BufferedWriter(new OutputStreamWriter(System.out));
 */
@Slf4j
@RestController
public class IoController {

    @Autowired
    private ByteStreamService byteStream;

    @Autowired
    private CharacterStreamService characterStream;

    @Resource
    private IoSetting ioSetting;

    /**
     * 字节流读写
     *
     * @param filePath
     * @throws Exception
     */
    @GetMapping(value = "/test/io/byteStream")
    public void redAndWriteByte(@PathParam("filePath") String filePath) throws Exception {
        log.info("----------byteStream：{}", filePath);
        byteStream.redAndWriteByte(filePath);
    }

    /**
     * 字符流读写
     *
     * @param filePath
     * @throws Exception
     */
    @GetMapping(value = "/test/io/charStream")
    public void redAndWriteChar(@PathParam("filePath") String filePath) throws Exception {
        log.info("-----------------Char:{}", filePath);
        characterStream.redAndWriteChar(filePath);
    }

    /**
     * 从控制台输入，将输入的文本写入文件,读取文件内容输出到控制台
     * @param filePath
     * @throws Exception
     */
    @GetMapping(value = "/test/io/iOStreamStateChange")
    public void iOStreamStateChange(@PathParam("filePath") String filePath) throws Exception {
        log.info("-----------------iOStreamStateChange:{}", filePath);
        characterStream.ioStreamStateChange(filePath);
    }

}

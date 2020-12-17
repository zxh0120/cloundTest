package com.service;

public interface CharacterStreamService {
    //字符流读写
    void redAndWriteChar(String filePath) throws Exception;
    //从控制台输入，将输入的文本写入文件,读取文件内容输出到控制台
    void ioStreamStateChange(String filePath) throws Exception;
}

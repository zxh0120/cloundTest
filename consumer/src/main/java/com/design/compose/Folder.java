package com.design.compose;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 组合模式
 * 容器对象
 * @since 2021/3/31
 **/
@Slf4j
public class Folder extends CustomizeFile {
    private List<CustomizeFile> files = null;

    public Folder(String name) {
        super(name);
        files = new ArrayList<>();
    }

    /**
     * 浏览文件夹中的文件
     */
    @Override
    public void display() {
        for (CustomizeFile file : files) {
            file.display();
        }
    }

    /**
     * 向文件夹中添加文件
     *
     * @param file
     */
    public void add(CustomizeFile file) {
        files.add(file);
    }

    /**
     * 先文件夹中移除文件
     *
     * @param file
     */
    public void delete(CustomizeFile file) {
        files.remove(file);
    }

}

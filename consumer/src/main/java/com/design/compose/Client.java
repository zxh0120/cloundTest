package com.design.compose;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 组合模式
 * 在文件系统中，可能存在很多种格式的文件，如果图片，文本文件、视频文件等等，
 * 这些不同的格式文件的浏览方式都不同，同时对文件夹的浏览就是对文件夹中文件的浏览，
 * 但是对于客户而言都是浏览文件，两者之间不存在什么差别，现在只用组合模式来模拟浏览文件
 * @since 2021/3/31
 **/
public class Client {
    public static void main(String[] args) {
        //总文件夹
        Folder folder = new Folder("总文件夹");
        //向总文件夹中放入三个文件：1.txt、b.jpg、C文件夹
        TextFile textFile = new TextFile("1.txt");
        ImagerFile imagerFile = new ImagerFile("b.jpg");
        Folder cFoler = new Folder("C文件夹");

        folder.add(textFile);
        folder.add(imagerFile);
        folder.add(cFoler);

        //向C文件夹中添加文件：c_1.txt、c_1.jpg、c_1.rmvb
        TextFile tFile = new TextFile("c_1.txt");
        ImagerFile iFile = new ImagerFile("c_b.jpg");
        VideoFile videoFile = new VideoFile("c_1.rmvb");

        cFoler.add(tFile);
        cFoler.add(iFile);
        cFoler.add(videoFile);

        //遍历C文件夹
        folder.display();
        //将c_1.txt删除
        cFoler.delete(tFile);
        System.out.println("-----------------------");
        folder.display();
    }
}

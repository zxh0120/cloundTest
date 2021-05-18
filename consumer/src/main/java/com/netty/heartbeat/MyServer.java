package com.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 编写一个 Netty 心跳检测机制案例,当服务器超过 3 秒没有读时，就提示读空闲
 * 当服务器超过 5 秒没有写操作时，就提示写空闲
 * 实现当服务器超过 7 秒没有读或者写操作时，就提示读写空闲
 * 代码如下：
 * @since 2021/4/16
 **/
public class MyServer {
    public static void main(String[] args) {

        //创建二个线程
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup(12);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, worker)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();//加入一个netty 提供 IdleStateHandler
                            /*
                             * 说明
                             *   1. IdleStateHandler 是netty 提供的处理空闲状态的处理器
                             *   2. long readerIdleTime : 表示多长时间没有读, 就会发送一个心跳检测包检测是否连接
                             *   3. long writerIdleTime : 表示多长时间没有写, 就会发送一个心跳检测包检测是否连接
                             *   4. long allIdleTime : 表示多长时间没有读写, 就会发送一个心跳检测包检测是否连接
                             *   5. 当 IdleStateEvent 触发后 , 就会传递给管道 的下一个handler去处理
                             *      通过调用(触发)下一个handler 的 userEventTiggered ,
                             *       在该方法中去处理 IdleStateEvent(读空闲，写空闲，读写空闲)
                             */
                            pipeline.addLast(new IdleStateHandler(7000, 7000, 10, TimeUnit.SECONDS));
                            //加入一个对空闲检测进一步处理的handler(自定义)
                            pipeline.addLast(new MyServerHandler());
                        }
                    });

            //启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}

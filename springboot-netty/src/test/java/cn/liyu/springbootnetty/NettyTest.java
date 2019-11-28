package cn.liyu.springbootnetty;

import cn.liyu.springbootnetty.netty.nettydemo.WebSocketChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liyu
 * @date 2019/11/27 16:32
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NettyTest {

    @Test
    public void WebSocketNettyServerTest() {
        //创建两个线程池
        NioEventLoopGroup mainGroup = new NioEventLoopGroup();//主线程池
        NioEventLoopGroup subGroup = new NioEventLoopGroup();//从线程池

        //创建netty服务器启动对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //初始化服务器启动对象
        serverBootstrap
                //指定使用上面创建的两个线程池
                .group(mainGroup, subGroup)
                //指定使用netty通道类型
                .channel(NioServerSocketChannel.class)
                //指定通道初始化器用来加载当Channel收到事件消息后，如何进行业务处理
                .childHandler(new WebSocketChannelInitializer());
        //绑定服务器端口，已同步的方式启动服务器
        try {
            ChannelFuture future = serverBootstrap.bind(9090).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭服务器
            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();
        }
    }
}

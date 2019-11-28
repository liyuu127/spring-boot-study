package cn.liyu.springbootnetty.netty.nettydemo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author liyu
 * @date 2019/11/27 16:43
 * @description 通道初始化器，用来加载通道处理器（ChannelHandler）
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 初始化通道,在这个方法中去加载对应的ChannelHandler
     *
     * @param socketChannel
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //获取管道，将一个一个的ChannelHandler添加到管道中
        ChannelPipeline pipeline = socketChannel.pipeline();

        //添加一个http的解码器
        pipeline.addLast(new HttpServerCodec());
        //添加一个用于大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        //添加一个聚合器，用于将HttpMessage聚合成FullHttpRequest/Response
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));

        //指定接收请求的路由必须使用以ws后缀结尾的url才能访问
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));


        //添加自定义的Handler
        pipeline.addLast(new ChatHandlerDemo());
    }
}

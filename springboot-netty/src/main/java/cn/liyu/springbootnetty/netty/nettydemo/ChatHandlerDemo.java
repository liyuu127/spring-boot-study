package cn.liyu.springbootnetty.netty.nettydemo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyu
 * @date 2019/11/27 17:00
 * @description 自定义通道处理器ChannelHandler
 */
public class ChatHandlerDemo extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //用来保存所有的客户端连接
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");


    /**
     * 当Channel中有新的事件消息会自动调用
     *
     * @param channelHandlerContext
     * @param textWebSocketFrame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        //当收到数据后自动调用

        //获取客户端发送过来的文本消息
        String text = textWebSocketFrame.text();
        System.out.println("接受的消息：text = " + text);

        for (Channel client : clients) {
            //将消息发送到所有的客户端
            client.writeAndFlush(new TextWebSocketFrame(sdf.format(new Date() )+ ":" + text));
        }

    }

    /**
     * 当有新的客户端连接到服务器之后，会自动调用这个方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //将新的通道加入到clients
        clients.add(ctx.channel());
    }
}

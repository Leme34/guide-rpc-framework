package github.javaguide;

import github.javaguide.entity.RpcServiceProperties;
import github.javaguide.proxy.RpcClientProxy;
import github.javaguide.remoting.transport.ClientTransport;
import github.javaguide.remoting.transport.socket.SocketRpcClient;

/**
 * ClientTransport 有 NettyClientTransport、SocketRpcClient 两种传输协议
 * 此处是 SocketRpcClient 的客户端例子
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
public class RpcFrameworkSimpleClientMain {
    public static void main(String[] args) {
        ClientTransport clientTransport = new SocketRpcClient();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2")
                .version("version2")
                .build();
        // 创建出service的动态代理
        RpcClientProxy rpcClientProxy = new RpcClientProxy(clientTransport, rpcServiceProperties);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new Hello("111", "222"));
        System.out.println(hello);
    }
}

import github.javaguide.HelloService;
import github.javaguide.entity.RpcServiceProperties;
import github.javaguide.remoting.transport.socket.SocketRpcServer;
import github.javaguide.serviceimpl.HelloServiceImpl;
import github.javaguide.serviceimpl.HelloServiceImpl2;

/**
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
public class RpcFrameworkSimpleServerMain {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2")
                .version("version2")
                .build();
        //服务注册
        socketRpcServer.registerService(helloService, rpcServiceProperties);
        // 启动服务端
        socketRpcServer.start();
    }
}

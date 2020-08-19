import github.javaguide.HelloService;
import github.javaguide.annotation.RpcScan;
import github.javaguide.entity.RpcServiceProperties;
import github.javaguide.remoting.transport.netty.server.NettyServer;
import github.javaguide.serviceimpl.HelloServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Server: Automatic registration service via @RpcService annotation
 *
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
@RpcScan(basePackage = {"github.javaguide.serviceimpl"})
public class NettyServerMain {
    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();

        // 启动注解环境的Spring容器
        // @RpcService注解包扫描进行服务注册，实现：github.javaguide.spring.SpringBeanPostProcessor
        new AnnotationConfigApplicationContext(NettyServerMain.class);

        // 进行手动服务注册
        HelloService helloService2 = new HelloServiceImpl2();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2")
                .version("version2")
                .build();
        nettyServer.registerService(helloService2, rpcServiceProperties);

        // 启动服务端
        nettyServer.start();
    }
}

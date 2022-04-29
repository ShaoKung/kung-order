# spring-cloud-alibaba
init version dubbo
# kung_utils 公共的方法jar
# service-api dubbo服务接口类jar
# service-gateway 网关服务，后需要支撑熔断，限流，负载均衡等等，日志记录最高级别，不做业务处理，只做请求分发
# service-receive 接收服务，接收网关进来的消息，落表后发消息，或者是调用其他的变更类服务，唯一不调用的是查询服务，后需要支撑熔断，限流，负载均衡
# service-query  查询服务，接收网关过来的查询请求，组装报文反馈给前端，需要支撑从drds或者一些nosql里查询
# service-consumer 消费服务，消费MQ中的消息，生成订单，以供后续生产，暂时简单模式(指定查询条件即可),后续需要支撑工作流
# service-stream 流式运算，消费者服务，消费mysql binlog的消息，流式计算
# service-job 调度服务，xxl-job为指导思想

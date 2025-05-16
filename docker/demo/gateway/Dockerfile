# 基础镜像
FROM openjdk:17

# 挂载目录
VOLUME /home/gateway
# 创建目录
RUN mkdir -p /home/gateway
# 指定路径
WORKDIR /home/gateway
# 复制jar文件到路径
COPY ./jar/gateway.jar /home/gateway/gateway.jar
# 启动用户服务
ENTRYPOINT ["java","-jar","gateway.jar"]

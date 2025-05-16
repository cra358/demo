# 基础镜像
FROM openjdk:17

# 挂载目录
VOLUME /home/user
# 创建目录
RUN mkdir -p /home/user
# 指定路径
WORKDIR /home/user
# 复制jar文件到路径
COPY ./jar/user.jar /home/user/user.jar
# 启动用户服务
ENTRYPOINT ["java","-jar","user.jar"]
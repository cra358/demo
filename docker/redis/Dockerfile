# 基础镜像
FROM redis:7.2.3

# 挂载目录
VOLUME /home/demo/redis
# 创建目录
RUN mkdir -p /home/demo/redis
# 指定路径
WORKDIR /home/demo/redis
# 复制conf文件到路径
COPY ./conf/redis.conf /home/demo/redis/redis.conf

#!/bin/bash

# 创建目标目录
mkdir -p ../mysql/db
mkdir -p ../demo/gateway/jar
mkdir -p ../demo/user/jar

# 复制sql文件
echo "begin copy sql "
cp ../../sql/db.sql ../mysql/db
echo "end copy sql "

# 复制jar文件
echo "begin copy jar "
cp ../../gateway/target/com.chenxw.demo.gateway-1.0-SNAPSHOT.jar ../demo/gateway/jar/gateway.jar
cp ../../user/target/com.chenxw.demo.user-1.0-SNAPSHOT.jar ../demo/user/jar/user.jar
echo "end copy jar "
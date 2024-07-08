
# 基于官方OpenJDK镜像
FROM openjdk:8u102-jdk
 
# 指定维护者信息
LABEL maintainer="18307200213@163.com"
 
# 暴露端口
EXPOSE 8080
 
# 添加jar包到容器中并更名为app.jar
ADD target/testWeb.jar testWeb.jar
 
# 执行jar包
ENTRYPOINT ["java", "-jar", "testWeb.jar"]

# 基于官方OpenJDK镜像
FROM openjdk:8u102-jdk
 
# 指定维护者信息
LABEL maintainer="18307200213@163.com"
 
# 可以将工作目录设置为/app
WORKDIR /app
 
# 复制pom.xml和源代码
COPY ./pom.xml ./src /app/
 
# 使用Maven打包应用程序
RUN mvn package
 
# 设置工作目录为生成的jar文件
WORKDIR /app/target

# 暴露8080端口
EXPOSE 80
 
# 运行Java应用程序
CMD ["java", "-jar", "myspringboot-0.0.1-SNAPSHOT.jar"]

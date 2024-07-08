
# 基于官方OpenJDK镜像
FROM openjdk:8u102-jdk
 
# 指定维护者信息
LABEL maintainer="18307200213@163.com"

# 可以将工作目录设置为/app
WORKDIR /app

# 复制pom.xml和源代码
COPY ./pom.xml ./src /app/

# 使用Maven打包应用程序
RUN mvn -U clean install -Dmaven.test.skip=true

# 设置工作目录为生成的jar文件
WORKDIR /app/target

COPY myspringboot-0.0.1-SNAPSHOT.jar ./

# 暴露端口
EXPOSE 80
 
# 执行jar包
ENTRYPOINT ["java", "-jar", "myspringboot-0.0.1-SNAPSHOT.jar"]

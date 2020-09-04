package com.my.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Karl
 */
@SpringBootApplication
@MapperScan(value = "com.my.platform.mapper")
public class PlatformApplication {

    /**
     * 1.在dao层（mapper接口）可以使用两个注解，@Repository 和 @Mapper,使用@Repository需要在启动类上添加@MapperScan(value = "mapper接口所在包路径")
     * 使用@Mapper注解的话不需要添加这个注解，但是在service层引入mapper时，会报红，提示无法自动注入，但是不影响使用，只影响美观。注意，这两个注解都是
     * 在使用mybatis的情况下使用的，所以mybatis要配置mapper文件的位置，即：mapper-locations: classpath:mapper/*.xml
     */
    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

}

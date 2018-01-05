package com.walle.family;

import com.walle.family.bean.Test;
import com.walle.family.dao.TestDao;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
@MapperScan("com.walle.family.dao")
public class FamilyApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(FamilyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FamilyApplication.class, args);
    }

    @Resource
    private TestDao testDao;

    @Override
    public void run(String... strings) throws Exception {
        Test test = testDao.selectTestById(1001);
        System.out.println(test.getName());
        logger.info("程序启动啦！！！");
    }
}

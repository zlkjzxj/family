package com.walle.family.dao;


import com.walle.family.bean.Test;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by walle
 * 2018/1/4 21:39
 * good good study,day day up!
 */
@Component
public interface TestDao {
    public Test selectTestById(int id);

    public List<Test> getTestList();

    public int insertATest(Test test);

    public int updateATest(Test test);
}

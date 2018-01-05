package com.walle.family.controller;


import com.walle.family.bean.Test;
import com.walle.family.dao.TestDao;
import com.walle.family.utils.Result;
import com.walle.family.utils.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class IndexController {

    @Resource
    private TestDao testDao;

    /**
     * 查询女生列表
     *
     * @return
     */
    @GetMapping("/getTests")
    public List<Test> getATestList() {

        return testDao.getTestList();
    }


    /**
     * 查询一个女生
     *
     * @return
     */
    @GetMapping("/getATest/{id}")
    public Test getATest(@PathVariable("id") int id) {
        return testDao.selectTestById(id);
    }

    /**
     * 保存一个女生
     *
     * @return
     */
    @PostMapping("insertATest")
    public Result<Test> insertATest(@Valid Test Test, BindingResult bindingResult) {//表单验证
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());

        } else {
            //事务返回的都是code代码，只能用int接收，需要其他参数自己封装
            int code = testDao.insertATest(Test);
            return ResultUtil.success(Test, code);
        }
    }

    /**
     * 修改一个女生
     *
     * @return
     */
    @PostMapping("updateATest")
    public Result<Test> updateATest(@Valid Test Test, BindingResult bindingResult) {//表单验证
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        } else {
            //事务返回的都是code代码，只能用int接收，需要其他参数自己封装
            int code = testDao.updateATest(Test);
            return ResultUtil.success(Test, code);
        }
    }
}

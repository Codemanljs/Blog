package com.ljs.blog.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.blog.pojo.Essay;
import com.ljs.blog.service.EssayService;
import com.ljs.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ljs
 * @create 2023-03-09 9:07
 */
@RestController
@RequestMapping("/essay")
public class EssayController {

    @Autowired
    EssayService essayService;

    //获取所有文章
    @GetMapping("/getAllEssay/{pageNo}/{pageSize}")
    public Result getAllEssay(@PathVariable("pageNo") Integer pageNo,@PathVariable("pageSize") Integer pageSize,Essay essay){
        PageHelper.startPage(pageNo, pageSize);
        //进行查询
        List<Essay> list = essayService.selectAllByOpr(essay);
        PageInfo<Essay> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }

    //删除文章
    @DeleteMapping("/deleteEssay/{essayId}")
    public Result deleteEssay(@PathVariable("essayId") Integer essayId){
        essayService.deleteEssayById(essayId);
        return Result.ok();
    }

    //修改文章
    @PutMapping("/updateEssay/{essayId}")
    public Result updateEssay(@PathVariable("essayId") Essay essay){
        essayService.updateEssayContent(essay);
        return Result.ok();
    }


    //添加文章
    @PutMapping("/insertEssay")
    public Result insertEssay(@RequestBody Essay essay){
        essayService.insertEssay(essay);

        return null;
    }


}

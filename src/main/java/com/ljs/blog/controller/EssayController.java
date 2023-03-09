package com.ljs.blog.controller;

import com.ljs.blog.pojo.Essay;
import com.ljs.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author ljs
 * @create 2023-03-09 9:07
 */
@RestController
public class EssayController {

    //获取所有文章
    @GetMapping("/getAllEssay/{pageNo}/{pageSize}")
    public Result getAllEssay(@PathVariable("pageNo") Integer pageNo,@PathVariable("pageSize") Integer pageSize){
        return null;
    }

    //删除文章
    @DeleteMapping("/deleteEssay/{essayId}")
    public Result deleteEssay(@PathVariable("essayId") Integer essayId){
        return null;
    }

    //修改文章
    @PostMapping("/updateEssay/{essayId}")
    public Result updateEssay(@PathVariable("essayId") Integer essayId){
        return null;
    }


    //添加文章
    @PutMapping("/insertEssay")
    public Result insertEssay(@RequestBody Essay essay){
        return null;
    }


}

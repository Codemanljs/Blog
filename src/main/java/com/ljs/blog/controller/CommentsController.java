package com.ljs.blog.controller;

import com.ljs.blog.pojo.Comments;
import com.ljs.blog.service.CommentsService;
import com.ljs.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ljs
 * @create 2023-03-10 11:48
 *
 * 评论控制器
 */


@RestController
@RequestMapping("/comments")
public class CommentsController {


    @Resource
    CommentsService commentsService;

    //查询所有评论
    @GetMapping("/getAllComByBlogId")
    public Result getAllComByBlogId(Integer blogId){
        List<Comments> list = commentsService.selectCommentsByBlogId(blogId);
        return Result.ok(list);
    }

    /*//查询单条评论
    @GetMapping("/getCom/{}")
    public Result getComments(){

    }*/


    //发布评论
    @PostMapping("/pushCom")
    public Result pushComments(@RequestBody Comments comments){
        commentsService.insertComments(comments);
        return Result.ok();
    }

    //删除评论
    @DeleteMapping("/deleteCom")
    public Result deleteComments(@RequestBody Integer Cid){
        commentsService.deleteCommentsByCid(Cid);
        return Result.ok();
    }

}

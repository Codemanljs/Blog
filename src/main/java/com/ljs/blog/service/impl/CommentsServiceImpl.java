package com.ljs.blog.service.impl;

import com.ljs.blog.mapper.CommentsMapper;
import com.ljs.blog.pojo.Comments;
import com.ljs.blog.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ljs
 * @create 2023-03-10 14:20
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Resource
    CommentsMapper commentsMapper;
    @Override
    public void insertComments(Comments comments) {
        Integer cid = comments.getCid();
        Integer eid = comments.getEid();
        Integer pid = comments.getPid();
        Integer uid = comments.getUid();
        String content = comments.getContent();
        Integer likeCount = comments.getLikeCount();
        commentsMapper.insertComments(cid,eid,uid,pid,content,likeCount);
    }

    @Override
    public List<Comments> selectCommentsByBlogId(Integer blogId) {
        List<Comments> commentsList = commentsMapper.selectAllCommentsByBlogId();
        return commentsList;
    }

    @Override
    public void deleteCommentsByCid(Integer cid) {
        commentsMapper.deleteCommentsByCid(cid);
    }


    //获取评论的子评论
    public List<Comments> selectCommByCid(Integer cId){
      List<Comments> list = commentsMapper.selectCommByCid(cId);
        return list;
      }

}






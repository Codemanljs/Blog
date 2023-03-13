package com.ljs.blog.mapper;

import com.ljs.blog.pojo.Comments;

import java.util.List;

/**
 * @author ljs
 * @create 2023-03-10 14:22
 */
public interface CommentsMapper {
    void insertComments(Integer cid,Integer eid,Integer uid,Integer pid,String text,Integer likeCount);

    List<Comments> selectAllCommentsByBlogId();

    List<Comments> selectCommByCid(Integer cId);

    void deleteCommentsByCid(Integer cid);
}

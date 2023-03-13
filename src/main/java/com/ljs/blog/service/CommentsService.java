package com.ljs.blog.service;

import com.ljs.blog.pojo.Comments;

import java.util.List;

/**
 * @author ljs
 * @create 2023-03-10 14:20
 */
public interface CommentsService {
    void   insertComments(Comments comments);

    List<Comments> selectCommentsByBlogId(Integer blogId);

    void deleteCommentsByCid(Integer cid);
}

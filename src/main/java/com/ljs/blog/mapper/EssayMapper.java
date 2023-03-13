package com.ljs.blog.mapper;

import com.ljs.blog.pojo.Essay;

import java.util.Date;
import java.util.List;

/**
 * @author ljs
 * @create 2023-03-09 16:49
 */
public interface EssayMapper {

    List<Essay> selectAllByOpr(String essayName);


    void deleteEssayById(Integer essayId);

    void updateEssayContent(String content,Integer essayId);

    void insertEssay(Integer essayId, Integer userId, String title, String content, long views, Date createTime, long likeCount);
}

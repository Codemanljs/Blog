package com.ljs.blog.service;

import com.ljs.blog.pojo.Essay;

import java.util.List;

/**
 * @author ljs
 * @create 2023-03-10 9:05
 */
public interface EssayService {
    List<Essay> selectAllByOpr(Essay essay);

    void deleteEssayById(Integer essayId);

    void updateEssayContent(Essay essay);

    void insertEssay(Essay essay);
}

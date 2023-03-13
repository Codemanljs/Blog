package com.ljs.blog.service.impl;

import com.ljs.blog.mapper.EssayMapper;
import com.ljs.blog.pojo.Essay;
import com.ljs.blog.service.EssayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ljs
 * @create 2023-03-10 9:05
 */
@Service
public class EssayServiceImpl implements EssayService {

    @Resource
    EssayMapper essayMapper;

    @Override
    public List<Essay> selectAllByOpr(Essay essay) {
        List<Essay> list = essayMapper.selectAllByOpr(essay.getTitle());
        return list;
    }

    @Override
    public void deleteEssayById(Integer essayId) {
        essayMapper.deleteEssayById(essayId);
    }

    @Override
    public void updateEssayContent(Essay essay) {
        String content = essay.getContent();
        Integer essayId = essay.getEssayId();
        essayMapper.updateEssayContent(content,essayId);
    }

    @Override
    public void insertEssay(Essay essay) {
        Integer essayId = essay.getEssayId();
        Integer userId = essay.getUserId();
        String content = essay.getContent();
        String title = essay.getTitle();
        Date createTime = essay.getCreateTime();
        long views = essay.getViews();
        long likeCount = essay.getLikeCount();
        essayMapper.insertEssay(essayId,userId,title,content,views,createTime,likeCount);
    }
}

package com.ljs.blog.pojo;

import lombok.Data;
import org.w3c.dom.Text;

import java.io.Serializable;
import java.sql.NClob;
import java.util.Date;

/**
 * @author ljs
 * @create 2023-03-09 9:08
 *
 * 文章类
 */
@Data
public class Essay implements Serializable {

    private Integer essayId;

    private Integer userId;

    private String title;

    private String content;

    private long views;

    private Date createTime;

    private long likeCount;

}

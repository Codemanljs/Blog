package com.ljs.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ljs
 * @create 2023-03-10 14:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    private Integer cid;

    private Integer uid;

    private Integer eid;

    private Integer pid;

    private String content;

    private Integer likeCount;

}

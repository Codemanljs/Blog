package com.ljs.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ljs
 * @create 2023-03-09 9:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer userId;

    private String username;

    private String password;

    private String tel;

//    private String auth;

//    private Long fans;

//    private List<Essay> essayList;
}

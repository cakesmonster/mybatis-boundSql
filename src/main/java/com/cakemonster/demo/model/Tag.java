package com.cakemonster.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Tag
 *
 * @author Zqh
 * @date 2020/4/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    /**
     * id
     */
    private String id;

    /**
     * 所属问题id
     */
    private String questionId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 更新时间
     */
    private Date gmtModified;

}

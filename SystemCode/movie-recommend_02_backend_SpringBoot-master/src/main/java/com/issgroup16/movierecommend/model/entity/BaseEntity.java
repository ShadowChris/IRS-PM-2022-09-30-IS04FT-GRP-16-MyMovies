package com.issgroup16.movierecommend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Shadow006
 * @Description 实体类基类，包含所有实体的一些共有属性，所有其他实体类需要继承此类
 */
@Data
public class BaseEntity implements Serializable {
    /** 备注 */
    private String remark;
    /** 创建人 */
    private String createdUser;
    /** 更新人 */
    private String updatedUser;
    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /** 更新时间 */
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
}

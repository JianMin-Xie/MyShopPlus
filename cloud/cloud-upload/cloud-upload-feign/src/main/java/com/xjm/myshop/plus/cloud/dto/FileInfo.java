package com.xjm.myshop.plus.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文件信息
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @date 2019-08-26 07:25:28
 * @see com.xjm.myshop.plus.cloud.dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo implements Serializable {
    /**
     * 文件路径
     */
    private String path;
}
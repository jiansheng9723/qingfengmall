package com.qingfeng.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h1>通用响应对象定义</h1>
 * {
 * "code": 100,
 * "note": "成功",
 * "result": {}
 * }
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse < T > implements Serializable {

        private Integer code;
        private String note;
        private T result;

        public CommonResponse ( Integer code , String note ) {
                this.code = code;
                this.note = note;
        }
}

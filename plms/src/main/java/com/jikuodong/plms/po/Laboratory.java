package com.jikuodong.plms.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 站点实验室
 * </p>
 *
 * @author jikuodong
 * @since 2019-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_eps_laboratory")
public class Laboratory extends Model<Laboratory> {

    private static final long serialVersionUID = 1L;

    /**
     * 站点实验室ID
     */
    @TableId("ID")
    private String id;

    /**
     * 实验室名称
     */
    @TableField("LAB_NAME")
    private String labName;

    /**
     * 实验室电话
     */
    @TableField("LAB_PHONE")
    private String labPhone;

    /**
     * 实验室地址
     */
    @TableField("LAB_ADDRESS")
    private String labAddress;

    /**
     * 实验室状态(0无效，1有效)
     */
    @TableField("LAB_STATUS")
    private Integer labStatus;

    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    @TableField("UPDATE_DATE")
    private LocalDateTime updateDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

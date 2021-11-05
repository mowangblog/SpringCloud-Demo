package top.mowang.cloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
@Getter
@Setter
@TableName("t_account")
@ApiModel(value = "TAccount对象", description = "")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("总额度")
    private BigDecimal total;

    @ApiModelProperty("已用余额")
    private BigDecimal used;

    @ApiModelProperty("剩余可用额度")
    private BigDecimal residue;


}

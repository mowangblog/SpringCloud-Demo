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
@TableName("t_order")
@ApiModel(value = "TOrder对象", description = "")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("产品id")
    private Long productId;

    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("金额")
    private BigDecimal money;

    @ApiModelProperty("订单状态: 0:创建中; 1:已完结")
    private Integer status;


}

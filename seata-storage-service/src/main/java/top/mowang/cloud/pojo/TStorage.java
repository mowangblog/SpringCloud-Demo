package top.mowang.cloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_storage")
@ApiModel(value = "TStorage对象", description = "")
public class TStorage implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("产品id")
    private Long productId;

    @ApiModelProperty("总库存")
    private Integer total;

    @ApiModelProperty("已用库存")
    private Integer used;

    @ApiModelProperty("剩余库存")
    private Integer residue;


}

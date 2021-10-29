package top.mowang.cloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xuan Li
 * @since 2021-10-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Payment对象", description = "")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String serial;


}

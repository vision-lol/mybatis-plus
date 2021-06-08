package cn.vision.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author vision
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@TableName("tb_user")
public class User {
    @TableField("id")
    private long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;

}

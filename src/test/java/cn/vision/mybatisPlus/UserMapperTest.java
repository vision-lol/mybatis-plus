package cn.vision.mybatisPlus;

import cn.vision.mybatisPlus.entity.User;
import cn.vision.mybatisPlus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        List<User> userList = userMapper.selectList(null);
        for (User user:userList){
            System.out.println(user);
        }
        /**查询age大于20的数据 ，name不是张三的数据  ne()*/
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ne("name","张三");
        wrapper.and(i->i.gt("age",20));
        List<User> rest = userMapper.selectList(wrapper);
        rest.forEach(System.out::println);
        System.out.println("=================================");
    }

    @Test
    public void insetTest(){
        User user = User.builder()
                .userName("vision")
                .age(20)
                .password("123456")
                .email("vision@163.cn")
                .name("skr")
                .build();
        int result = userMapper.insert(user);
        System.out.println("影响的行数："+result);
        System.out.println(user);
    }

    @Test
    public void updateTest(){
        User user = User.builder().userName("skr").email("skr@163.cn").build();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","vision");
        wrapper.eq("email","vision@163.cn");
        userMapper.update(user,wrapper);
    }

    /**根据ID 批量查询*/
    @Test
    public void selectBatchIds(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2));
        userList.forEach(System.out::println);
    }

    @Test
    public void selectTest(){

    }
}

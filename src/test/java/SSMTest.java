import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.mapper.UserMapper;
import com.zeusjava.kernel.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by LittleXuan on 2015/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class SSMTest {
    private static Logger logger = LoggerFactory.getLogger(SSMTest.class);
    @Resource
    private IUserService userService;
    @Resource
    private UserMapper userMapper;

    @Test
    public void test1() {
        long beginTime=System.nanoTime();
        User user = userService.getUserById(1);
        long endTime=System.nanoTime();
        System.out.println("查询时间 :" + (endTime-beginTime));
        logger.info("姓名："+user.getUserName());
//        logger.info(JSON.toJSONString(user));
    }
    @Test
    public void testUser(){
        User user = new User("testUser","123456");
        int insertResult = userMapper.insertSelective(user);
        Assert.assertEquals(1,insertResult);
        int userId = user.getId();
        User userFind = userMapper.selectUserByUserId(userId);
        Assert.assertNotNull(userFind);
        userFind.setUserName("newUser");
        int updateResult = userMapper.updateByPrimaryKeySelective(userFind);
        Assert.assertEquals(1,updateResult);
        Assert.assertEquals("newUser",userMapper.selectUserByUserId(userId).getUserName());
    }
}

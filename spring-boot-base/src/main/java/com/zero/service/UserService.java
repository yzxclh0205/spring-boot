package com.zero.service;

import com.zero.dao.UserMapper;
import com.zero.enums.CodeEnum;
import com.zero.po.User;
import com.zero.po.UserExample;
import com.zero.vo.dto.UserDto;
import com.zero.web.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @author: yezhaoxing
 * @date: 2017/4/29
 */
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;

    public int login(String username, String password) throws BaseException {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()) {
            throw new BaseException(CodeEnum.LOGIN_FAIL, "用户名或者密码错误!");
        } else {
            Integer userId = users.get(0).getId();
            LOG.info("userId={} login success", userId);
            return userId;
        }
    }

    public User getUserInfo(int userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setPassword("******");
        return user;
    }

    @Transactional
    public int add(UserDto userDto) {
        User tmp = new User();
        tmp.setAge(userDto.getAge());
        String name = userDto.getName();
        tmp.setName(name);
        tmp.setPassword(userDto.getPassword());
        String phone = userDto.getPhone();
        tmp.setPhone(phone);
        userMapper.insertSelective(tmp);
        LOG.info("name={} phone={} register success", name, userDto.getPassword());
        return tmp.getId();
    }
}

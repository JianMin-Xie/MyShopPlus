package com.xjm.myshop.plus.provider.service;

import com.xjm.myshop.plus.provider.api.UmsAdminService;
import com.xjm.myshop.plus.provider.domain.UmsAdmin;
import com.xjm.myshop.plus.provider.mapper.UmsAdminMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户管理服务
 * <p>
 * Description:
 * </p>
 *
 * @author Administrator
 * @version v1.0.0
 * @since 2020-03-04 20:36:46
 * @see com.xjm.myshop.plus.provider.service
 *
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public int insert(UmsAdmin umsAdmin) {
        //初始化用户对象
        initUmsAdmin(umsAdmin);

        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin get(String username) {
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username", username);

        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    @Override
    public int update(UmsAdmin umsAdmin) {
        UmsAdmin oldUmsAdmin = get(umsAdmin.getUsername());

        oldUmsAdmin.setEmail(umsAdmin.getEmail());
        oldUmsAdmin.setNickName(umsAdmin.getNickName());
        oldUmsAdmin.setNote(umsAdmin.getNote());
        oldUmsAdmin.setStatus(umsAdmin.getStatus());

        return umsAdminMapper.updateByPrimaryKey(oldUmsAdmin);
    }

    /**
     * 初始化用户对象
     */
    private void initUmsAdmin(UmsAdmin umsAdmin){
        //初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        //初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        //密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));


    }
}

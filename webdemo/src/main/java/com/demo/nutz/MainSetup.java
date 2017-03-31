package com.demo.nutz;

import com.demo.nutz.model.User;
import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import java.util.Date;

/**
 * MainSetup
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/3/30
 */
public class MainSetup implements Setup {
    @Override
    public void init(NutConfig nc) {
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        dao.create(User.class, false);

        if (dao.count(User.class) == 0) {
            User user = new User();
            user.setName("admin");
            user.setPassword("123456");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            dao.insert(user);
        }

    }

    @Override
    public void destroy(NutConfig nc) {

    }
}

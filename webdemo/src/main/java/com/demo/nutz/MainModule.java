package com.demo.nutz;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * MainModule
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/3/30
 */
// 请注意星号!!不要拷贝少了
@IocBy(type=ComboIocProvider.class, args={"*js", "config/",
        // 这个package下所有带@IocBean注解的类,都会登记上
        "*anno", "com.demo.nutz",
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
@Modules(scanPackage = true)
@Ok("json:full")
@Fail("jsp:jsp.500")
@SetupBy(value = MainSetup.class)
public class MainModule {
}

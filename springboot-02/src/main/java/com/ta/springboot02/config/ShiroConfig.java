package com.ta.springboot02.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ta.springboot02.pojo.Resource;
import com.ta.springboot02.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class ShiroConfig {

    /*
        Subject 用户
        SecurityManager 管理用户
        Realm 连接数据

    */
//    1.ShiroFillterFactoryBean
    @Autowired
    private  ResourceService resourceService;

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager manager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(manager);

        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();//linkHashMap
        /*
            shiro 内置过滤器
                anon：无需认证即可访问
                authc：必须认证才可以访问
                uer：必须拥有 记住我 功能才能用
                perms：拥有对某个资源的权限才能访问
                role：

                */

        /*
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        */

//        资源授予需要的权限
        /*
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        */
//        更改为从数据库读取 给所有需要设置权限的请求连接 授予权限。
        List<Resource> all = resourceService.findAll();

        for (Resource resource : all) {
//            if(resource.isPower()){
                //动态-->认证
                filterMap.put(resource.getUrl(),"authc");
                //动态-->资源授予需要的权限
                filterMap.put(resource.getUrl(),"perms[" + resource.getPerm() + "]");
//            }
        }

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

//        设置登陆页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
//        设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/toUnauthorized");
        return shiroFilterFactoryBean;
    }
//    2.DefaultWebSecurityManager

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRelam") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
//    3.创建Realm 对象，需要自定义类 授权认证逻辑
    @Bean
    public Realm userRelam(){
        return new UserRealm();
    }

//    整合shiroDialet： 用来整合shiroDialet

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}

package com.ta.springboot02.config;

import com.ta.springboot02.pojo.Permission;
import com.ta.springboot02.pojo.Resource;
import com.ta.springboot02.pojo.User;
import com.ta.springboot02.service.PermissionService;
import com.ta.springboot02.service.ResourceService;
import com.ta.springboot02.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    public static final String DEFAULT_ROLE = "admin";

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ResourceService resourceService;

//    授权--collection
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了=====>授权doGetAuthorizationInfo ");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        Set<String> stringPermissions = new HashSet<>();
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();


        if(primaryPrincipal instanceof User){
            User user = (User) primaryPrincipal;

            List<String> perms = new ArrayList<>();



            if(user.getRole().equals(DEFAULT_ROLE)){
                //所有的资源权限,定义只要是admin角色，就拥有所有资源的权限。
                List<Resource> all = resourceService.findAll();
                for (Resource permission : all) {
                    perms.add(permission.getPerm());
                }
                stringPermissions.addAll(perms);
            }else{
                List<Permission> permissions = permissionService.selectByRole(user.getRole());
                for (Permission permission : permissions) {
                    perms.add(permission.getPerms());
                }
                stringPermissions.addAll(perms);
            }


        }


        /*if(null!=primaryPrincipal&&primaryPrincipal.getName().equals("root")){

            stringPermissions.add("user:add");
        }
*/

        simpleAuthorizationInfo.addStringPermissions(stringPermissions);

        return simpleAuthorizationInfo;
    }

//    token认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("执行了=====>认证：doGetAuthenticationInfo ");

        UsernamePasswordToken usernamePasswordToken =  (UsernamePasswordToken)token;

        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        if(null==user){
            return null;
        }

//        登陆成功放session
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("loginUser",user);

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }

}

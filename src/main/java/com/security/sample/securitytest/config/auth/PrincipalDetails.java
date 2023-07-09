package com.security.sample.securitytest.config.auth;


// 시큐리티가 /login 낚아채서 로그인을 진행 시킴
// 로그인을 진행이 완료가 되면 시큐리티 session을 만들어줍니다. (Security ContextHolder)
// 오브젝트 => Authentication 객체여야됨
// Authentication 안에 User 정보가 있어야 됨.
// User오브젝트타입 => UserDetails 타입 객체여야됨
// 시큐리티가 가지고 있는 Security Session = > Authentication 여야됨
// 즉 Security Session => Authentication => UserDetails

import com.security.sample.securitytest.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {
    private User user;

    public PrincipalDetails(User user) {
        this.user=user;
    }
    // 해당 유저의 권한을 return
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.dragonsky.nextpage.config.security.auth;


import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsProvider {
    UserDetails loadUserById(Long userId);
}

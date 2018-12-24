package com.achieverprince.quiz.service;

import com.achieverprince.quiz.entity.ApplicationUser;
import com.achieverprince.quiz.entity.Privilege;
import com.achieverprince.quiz.entity.Role;
import com.achieverprince.quiz.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EntityManager entityManager;
    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUserName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        List<Role> roleList = applicationUser.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(int i=0;i<roleList.size();i++)
        {
            Role role = roleList.get(i);
            List<Privilege> privileges = role.getPrivileges();
            for(int j=0;j<privileges.size();j++)
            {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(privileges.get(j).getPrivilegeCode());
                authorities.add(grantedAuthority);
            }
        }
        return new User(applicationUser.getUserName(), applicationUser.getPassword(), authorities);
    }
}

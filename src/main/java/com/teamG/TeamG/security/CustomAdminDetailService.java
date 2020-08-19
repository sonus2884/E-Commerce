package com.teamG.TeamG.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teamG.TeamG.model.Admin;
import com.teamG.TeamG.repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomAdminDetailService  implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByEmail(s);
        
        if(admin == null){
            throw new UsernameNotFoundException("Admin  Name not found");
        }

//        GrantedAuthority grantedAuthority = new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return admin.getRole();
//            }
//        };

		
        List<GrantedAuthority> authorities =
                new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(admin.getRole()));
		  
		  return new User( admin.getEmail(), admin.getPassword(), authorities );
		 
//        return null;
    }
}


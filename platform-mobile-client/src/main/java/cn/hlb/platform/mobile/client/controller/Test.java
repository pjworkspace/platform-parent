package cn.hlb.platform.mobile.client.controller;

import cn.hlb.platform.common.utils.RandomHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static AuthenticationManager authenticationManager = new SampleAuthenticationManager();

    public static void main(String[] args) throws Exception {
            System.out.println(RandomHelper.randomOrderId());
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String  s = encoder.encode("123456");
        System.out.println(encoder.encode("123456"));
        System.out.println(encoder.matches("123456",s));
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            System.out.println("Please enter your username:");
//            String name = in.readLine();
//            System.out.println("Please enter your password:");
//            String password = in.readLine();
//            try {
//                Authentication request = new UsernamePasswordAuthenticationToken(name, password);
//                System.out.println("before:" + request);
//                Authentication result = authenticationManager.authenticate(request);
//                System.out.println("after:" + result);
//                SecurityContextHolder.getContext().setAuthentication(result);
//                break;
//            } catch (AuthenticationException e) {
//                System.out.println("Authentication failed: " + e.getMessage());
//            }
//        }
//        System.out.println("Successfully authenticated. Security context contains: " +
//                SecurityContextHolder.getContext().getAuthentication());
    }



}

class SampleAuthenticationManager implements AuthenticationManager {
    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.getName().equals(auth.getCredentials())) {
            return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }
}
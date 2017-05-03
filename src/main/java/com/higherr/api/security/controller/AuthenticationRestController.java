package com.higherr.api.security.controller;

import com.higherr.api.security.JwtAuthenticationBySocialLoginRequest;
import com.higherr.api.security.JwtAuthenticationRequest;
import com.higherr.api.security.JwtTokenUtil;
import com.higherr.api.security.JwtUser;
import com.higherr.api.security.service.JwtAuthenticationResponse;
import com.higherr.api.security.service.JwtUserDetailsService;
import com.higherr.api.security.service.SocialAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.social}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationTokenBySocialLogin(@RequestBody JwtAuthenticationBySocialLoginRequest authenticationRequest, Device device) throws AuthenticationException {

        String token = authenticationRequest.getToken();
        SocialAuthenticationService socialAuthenticationService = new SocialAuthenticationService(token);
        if (socialAuthenticationService.isValidToken()) {
            try {
                UserDetails userDetails = userDetailsService.loadUserByEmail(socialAuthenticationService.getUserProfile().getEmail());
                // Perform the security
//                final Authentication authentication = authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                userDetails.getUsername(),
//                                userDetails.getPassword()
//                        )
//                );
                final String ourToken = jwtTokenUtil.generateToken(userDetails, device);
                // Return the token
                return ResponseEntity.ok(new JwtAuthenticationResponse(ourToken));
            } catch (UsernameNotFoundException exception) {
                // @todo generate user with password default

            }

        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

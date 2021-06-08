package com.example.meetingOfficePlanner.meetingOfficePlanner.config;

import com.example.meetingOfficePlanner.meetingOfficePlanner.model.AuthenticationRequest;
import com.example.meetingOfficePlanner.meetingOfficePlanner.model.AuthenticationResponse;
import com.example.meetingOfficePlanner.meetingOfficePlanner.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {
    //    @GetMapping("/")
//    public String home(){
//        return ("<h1>Welcome<h1>");
//    }
//    @GetMapping("user")
//    public String user(){
//        return ("<h1>Welcome user<h1>");
//    }
//    @GetMapping("/admin")
//    public String admin(){
//        return ("<h1>Welcome admin<h1>");
//    }
    @Autowired
    private
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @


            RequestMapping({"/hello"})
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}

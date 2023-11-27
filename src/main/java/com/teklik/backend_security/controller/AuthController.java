// package com.teklik.backend_security.controller;

// import java.util.Optional;

// import org.springframework.http.ResponseEntity;
// // import org.springframework.security.core.userdetails.UsernameNotFoundException;
// // import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// // import com.teklik.backend_security.interfaces.AuthService;
// // import com.teklik.backend_security.model.JWTAuthResponse;
// import com.teklik.backend_security.model.LoginDto;
// import com.teklik.backend_security.model.User;
// import com.teklik.backend_security.repository.UserRepository;

// // import com.teklik.el_shadai_backend.repository.LoginRepository;
// // import com.teklik.el_shadai_backend.repository.UserRepository;

// @CrossOrigin("*")
// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {
//     private UserRepository userRepository;

//     // Build Login REST API
//     @GetMapping("/login")
//     public User authenticate(@RequestBody LoginDto loginDto){
//         // Optional<User> user = userRepository.findByUsernameAndPassword(loginDto.getUsernameOrEmail(), loginDto.getPassword());
//         Optional<User> user = userRepository.findByUsername(loginDto.getUsernameOrEmail());
//         // userRepository.find
//             if(user.get() == null){
//                 return null;
//             }else{
//                 return user.get();
//             }
//     }
// }

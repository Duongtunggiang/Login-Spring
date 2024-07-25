package com.duong.store.controll;

import com.duong.store.models.AppUer;
import com.duong.store.models.RegisterDto;
import com.duong.store.respository.AppUserRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class AccountController {
    @Autowired
    private AppUserRespository repo;

    @GetMapping("/register")
    public String register(Model model){
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success",false);
        return "register";
    }
    @PostMapping("/register")
    public String registers(Model model, @Valid @ModelAttribute RegisterDto registerDto,
                            BindingResult result){
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
            result.addError(
                    new FieldError("registerDto","confirmPassword",
                            "Password and Confirm password do not match")
            );
        }
        AppUer appUer = repo.findByEmail(registerDto.getEmail());
        if (appUer != null){
            result.addError(
                    new FieldError("registerDto","email",
                            "Email address is already used")
            );
        }
        if (result.hasErrors()){
            return "register";
        }

        try {
            var bCryptEncoder = new BCryptPasswordEncoder();

            AppUer newUser = new AppUer();
            newUser.setFirstName(registerDto.getFirstName());
            newUser.setLastName(registerDto.getLastName());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone(registerDto.getPhone());
            newUser.setAddress(registerDto.getAddress());
            newUser.setRole("client");
            newUser.setCreatAt(new Date());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));

            repo.save(newUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success",true);

        }catch (Exception e){
            result.addError(
                    new FieldError("registerDto","firstName",
                            e.getMessage())
            );
        }

        return "register";
    }
}

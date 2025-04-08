package kr.co.greenpai.controller;

import kr.co.greenpai.dto.User1DTO;
import kr.co.greenpai.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1/list")
    public String list(Model model){

        List<User1DTO> user1DTOList = user1Service.findAll();
        model.addAttribute("users",user1DTOList);
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        user1Service.save(user1DTO);
        return "/user1/register";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){
        System.out.println("출력");
        User1DTO user1DTO = user1Service.findById(uid);
        model.addAttribute(user1DTO);
        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        user1Service.modify(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid){
        user1Service.delete(uid);
        return "redirect:/user1/list";
    }

}

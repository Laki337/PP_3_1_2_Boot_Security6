package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "")
	public String printWelcome(ModelMap model) {
		model.addAttribute("users", userService.getUsers());
		return "users";
	}
	
	@DeleteMapping("/{id}/delete")
	public String usersDelete(@PathVariable(value = "id") Long id) {
		System.err.println("AAA");
		userService.deleteUser(id);
		return "redirect:/users";
	}
	
	@PostMapping("/createUser")
	public String userAdd(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "redirect:/users";
	}
	@PutMapping ("/updateUsers")
	public String updateDepartament(@ModelAttribute("user") User user){
		userService.updateUser(user);
		
		return "redirect:/users";
	}
}
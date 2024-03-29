package fr.dawan.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.springmvc.beans.User;
import fr.dawan.springmvc.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService service;
	
	/*
	 * ModelAndView permet de transmettre la vue et les attributs avec un seul return
	 */
	@GetMapping("/users")
	public ModelAndView listUser() {
		List<User> users = service.getAllUsers();
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName("usersview");
		
		modelView.addObject("users", users);
		return modelView;
		
	}
	
	/*
	 * Admin pourra effacer un user par son id
	 * 
	 * @PathVariable : 
	 * @PathVariable est une annotation Spring qui indique qu'un param�tre de la m�thode
	 * doit �tre li� � une variable de la requete
	 */
	@GetMapping("/users/delete/{id}")
	public String deleteUser(Model model, @PathVariable Long id) {
		User user = service.getUser(id);
		if(user != null) {
			service.deleteUser(id);
		}
		return "redirect:/admin/users";
	}
	
//	public String addUser(Model model) {
//		model.addAttribute("formuser", )
//	}
	
	
}

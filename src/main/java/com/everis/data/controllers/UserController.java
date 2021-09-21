package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.data.models.Carrito;
import com.everis.data.models.User;
import com.everis.data.services.CarritoService;
import com.everis.data.services.ProductoService;
import com.everis.data.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private CarritoService cs;
	
	
	@Autowired
	private ProductoService ps;
	
	
	@RequestMapping("/")
	public String inicio(HttpSession session) {
		if(session.getAttribute("userId")!=null ) {
			return "redirect:/tienda";
			
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/tienda")
	public String tienda(Model model, HttpSession session ) {
		User user = us.findById( Long.parseLong( (session.getAttribute("userId").toString())) );
		model.addAttribute("lista_productos", ps.findAll());
		Carrito carrito = cs.findById(Long.parseLong( (session.getAttribute("userId").toString())));
		model.addAttribute("lista_carrito", carrito.getCarritos_productos() );
		model.addAttribute("carrito", carrito );
		model.addAttribute("cantidad_carrito", carrito.getCarritos_productos().size() );
		model.addAttribute("id_carrito", user.getCarritos().get(0).getId());
		return "tienda.jsp";
	}
	
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("user") User user ) {
		
		return "registro.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession session ) {
		boolean existeUsuario = us.validarUsuario(usuario, password);
		if(existeUsuario) {
			User user = us.findByUsuario(usuario);
			session.setAttribute("userId", user.getId() );
			session.setAttribute("user", user.getUsuario() );
			return "redirect:/tienda";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("user") User user , RedirectAttributes redirectAttrs ) {
		boolean existeUsuario = us.validarUsuario(user.getUsuario(), user.getPassword());
		if(!existeUsuario) {
			us.save(user);
			Carrito carrito = new Carrito( "0", "0");
			carrito.setUser(user);
			cs.save(carrito);
			redirectAttrs.addFlashAttribute("mensaje", "Usuario creado correctamente");
			return "redirect:/login";
		}else {
			redirectAttrs.addFlashAttribute("mensaje", "Usuario ya existe");
			System.out.println("Usuario ya existe");
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		if(session.getAttribute("userId")!=null ) {
			return "home.jsp";
			
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("userId")!=null  ) {
			session.invalidate(); //Matamos todas las variables de session
		}
		return "redirect:/login";
	}
	
	
}

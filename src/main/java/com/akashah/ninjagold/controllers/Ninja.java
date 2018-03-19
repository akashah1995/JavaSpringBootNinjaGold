package com.akashah.ninjagold.controllers;
import static org.mockito.Matchers.intThat;

import java.util.*;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akashah.ninjagold.models.NinjaEarnings;

@Controller
public class Ninja {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("totalgold") == null) {
			session.setAttribute("totalgold",0);
		}
		return "Home.jsp";
	}
	@RequestMapping("/Farm")
	public String FarmMoney(HttpSession session) {
		Random generator = new Random();
		int earned = generator.nextInt(10) + 10;
		String phrase = String.format("You earned %d gold at the Farm!", earned);
		String color = "green";
		NinjaEarnings ninjaearnings = new NinjaEarnings(phrase,color);
		
		if (session.getAttribute("earnings") == null) {
			ArrayList <NinjaEarnings> earnings = new ArrayList <NinjaEarnings>();
			session.setAttribute("earnings",earnings);
			}
		
		ArrayList <NinjaEarnings> totalearnings = (ArrayList <NinjaEarnings>) session.getAttribute("earnings");
		totalearnings.add(ninjaearnings);
		session.setAttribute("earnings", totalearnings);
		
		int totalgold = (int) session.getAttribute("totalgold");
		totalgold = totalgold + earned;
		session.setAttribute("totalgold", totalgold);
		
		return "redirect:/";
	
	}
	@RequestMapping("/Cave")
	public String CaveMoney(HttpSession session) {
		Random generator = new Random();
		int earned = generator.nextInt(5) + 5;
		String phrase = String.format("You earned %d gold at the Cave!", earned);
		String color = "green";
		NinjaEarnings ninjaearnings = new NinjaEarnings(phrase,color);
		
		if (session.getAttribute("earnings") == null) {
			ArrayList <NinjaEarnings> earnings = new ArrayList <NinjaEarnings>();
			session.setAttribute("earnings",earnings);
			}
		
		ArrayList <NinjaEarnings> totalearnings = (ArrayList <NinjaEarnings>) session.getAttribute("earnings");
		totalearnings.add(ninjaearnings);
		session.setAttribute("earnings", totalearnings);
		
		int totalgold = (int) session.getAttribute("totalgold");
		totalgold = totalgold + earned;
		session.setAttribute("totalgold", totalgold);
		
		return "redirect:/";
	
	}
	@RequestMapping("/House")
	public String HouseMoney(HttpSession session) {
		Random generator = new Random();
		int earned = generator.nextInt(3) + 2;
		String phrase = String.format("You earned %d gold at the house!", earned);
		String color = "green";
		NinjaEarnings ninjaearnings = new NinjaEarnings(phrase,color);
		
		if (session.getAttribute("earnings") == null) {
			ArrayList <NinjaEarnings> earnings = new ArrayList <NinjaEarnings>();
			session.setAttribute("earnings",earnings);
			}
		
		ArrayList <NinjaEarnings> totalearnings = (ArrayList <NinjaEarnings>) session.getAttribute("earnings");
		totalearnings.add(ninjaearnings);
		session.setAttribute("earnings", totalearnings);
		
		int totalgold = (int) session.getAttribute("totalgold");
		totalgold = totalgold + earned;
		session.setAttribute("totalgold", totalgold);
		
		return "redirect:/";
	}
	@RequestMapping("/Casino")
	public String CasinoMoney(HttpSession session) {
		Random generator = new Random();
		int earned = generator.nextInt(100) + -50;
		NinjaEarnings ninjaearnings = null;
		if (earned >= 0) {
			String phrase = String.format("You earned %d gold at the Casino!", earned);
			String color = "green";
			ninjaearnings = new NinjaEarnings(phrase,color);
		}
		else {
			String phrase = String.format("You lost %d gold at the Casino!", earned);
			String color = "red";
			ninjaearnings = new NinjaEarnings(phrase,color);
		}
			
		if (session.getAttribute("earnings") == null) {
			ArrayList <NinjaEarnings> earnings = new ArrayList <NinjaEarnings>();
			session.setAttribute("earnings",earnings);
			}
		
		ArrayList <NinjaEarnings> totalearnings = (ArrayList <NinjaEarnings>) session.getAttribute("earnings");
		totalearnings.add(ninjaearnings);
		session.setAttribute("earnings", totalearnings);
		
		int totalgold = (int) session.getAttribute("totalgold");
		totalgold = totalgold + earned;
		session.setAttribute("totalgold", totalgold);
		
		return "redirect:/";
	}
	
	@RequestMapping("/Reset")
	public String Reset(HttpSession session) {
		session.setAttribute("earnings", null);
		session.setAttribute("totalgold", null);
		return "redirect:/";
	}
	
	

}

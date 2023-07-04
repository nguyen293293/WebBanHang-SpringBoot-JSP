package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.AccountService;
import com.demo.service.CartService;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
	@Autowired
	HttpSession session;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	AccountService accountService;

	@Autowired
	CartService cart;

	@ModelAttribute("cart")
	CartService getCart(){
		return cart;
	}

	@Data @AllArgsConstructor
	public static class PriceRange{
		int id;
		int minValue;
		int maxValue;
		String display;
	}

	List<PriceRange> priceRangeList = Arrays.asList(
		new PriceRange(0,0, Integer.MAX_VALUE, "Tất cả"),
		new PriceRange(1,0, 999999, "Dưới 1 triệu"),
		new PriceRange(2,1000000, 1999999, "Từ 1-2 triệu"),
		new PriceRange(3,2000000, Integer.MAX_VALUE, "Trên 2 triệu")
	);

	@RequestMapping("/")
	public String index(
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String categoryId,
			@RequestParam(defaultValue="0") int priceRangeId,
			@RequestParam(defaultValue="0") int p,
			Model model) {

		if(session.getAttribute("username") == null){
			return  "redirect:/login";
		}
		model.addAttribute("priceRangeList", priceRangeList);
		model.addAttribute("categoryList", categoryService.findAll());

		int minPrice = priceRangeList.get(priceRangeId).minValue;
		int maxPrice = priceRangeList.get(priceRangeId).maxValue;

//		Sort sort = Sort.by(Sort.Direction.ASC, "name");
//		model.addAttribute("productList",
//				productService.fillter("%" + keyword + "%", "%" + categoryId + "%", minPrice, maxPrice, pageable));

		Pageable pageable = PageRequest.of(p, 3);
		model.addAttribute("productList",
				productService.fillter1("%" + keyword + "%", "%" + categoryId + "%", minPrice, maxPrice, pageable));


		System.out.println("keyword=" + keyword);
		System.out.println("categoryId=" + categoryId);
		System.out.println("minPrice=" + minPrice);
		System.out.println("maxPrice=" + maxPrice);
		System.out.println("page=" + p);

		return "home/index";
	}

	@GetMapping("/detail/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "home/detail";
	}

	@RequestMapping("/add-to-cart/{id}")
	public String addToCart(@PathVariable int id){
		cart.add(id);
		return "redirect:/cart";
	}

	@RequestMapping("/remove-cart/{id}")
	public String removeCart(@PathVariable int id) {
		cart.remove(id);
		if(cart.getTotal() == 0){
			return "redirect:/";
		}
		return "redirect:/cart";
	}

	@RequestMapping("/update-cart/{id}")
	public String updateCart(@PathVariable int id, int quantity) {
		cart.update(id, quantity);
		return "redirect:/cart";
	}

	@GetMapping("/cart")
	public String cart(){
		return "home/cart";
	}

	@GetMapping("/confirm")
	public String confirm(){
		return "home/confirm";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		return "home/about";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		// TODO: Check if user/password exists in database
		if(accountService.checkLogin(username, password) != null) {
			session.setAttribute("username", username);
			return "redirect:/";
		}
		model.addAttribute("message", "Tên đăng nhập/mật khẩu không đúng");
		return "login";
	}

	@PostMapping("/purchase")
	public String purchase(@RequestParam String address){
		System.out.println("address=" + address);
		System.out.println("items=" + cart.getItems());
		// TODO: Save items to database
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(){
		session.removeAttribute("username");
		return "redirect:/login";
	}
}

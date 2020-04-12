package com.example.restaurentService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurentController {
	@Autowired
	private RestaurentService restaurentService;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/get-restaurents")	//API TO GET RESTAURENTS
	public List<Restaurent> getRestaurentsAPI(HttpServletRequest request) {
		final Map<String, String[]> parameters = request.getParameterMap();

		try {
			return restaurentService.getRestaurents(parameters);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/get-all-categories") //API TO GET CATEGORIES OF RSTAURENTS IN THE SYSTEM
	public List<Category> getCategoriesAPI(HttpServletRequest request) {
		System.out.println("fetching Categories");
		return restaurentService.getCategoriesService();
		
	}

	@GetMapping("/greeting-javaconfig")
	public Restaurent greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
		System.out.println("==== in greeting ====");
		return null;
	}

}

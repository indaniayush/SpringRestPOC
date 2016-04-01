package spring.rest.controller;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.rest.database.MockDB;
import spring.rest.model.User;

import com.google.gson.Gson;

@RestController
public class UserController {

	@RequestMapping(value = "/")
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("User");
		return mav;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> newCustomer(@RequestBody User user)
			throws IOException {

		Gson gson = new Gson();
		String json = gson.toJson(user);

		System.out.println("Json: \n" + json);

		MockDB mdb = new MockDB(user.getEmail());
		mdb.saveJson(json);

		System.out.println("\nWelcome\n\n");
		// return "OK";
		return new ResponseEntity<String>("Resgistration Success",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/Success")
	public ModelAndView loadSuccess() {

		ModelAndView mav = new ModelAndView("Success");
		return mav;
	}

}

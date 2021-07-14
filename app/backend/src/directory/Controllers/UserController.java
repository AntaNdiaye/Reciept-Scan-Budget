package directory.Controllers;

import directory.models.Receipt;
import directory.models.User;
import directory.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

	private UserService userService;

	public  UserController(UserService userService){
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Creates a new user instance for app
	 */
	@PutMapping("/User")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody User newUser) {
		userService.createUser(newUser);
	}
	@GetMapping("/User/{useId}/Reciepts")
	public List<Receipt> getUserReciepts(@PathVariable long userId) {
		return userService.getUserReciepts(userId);
	}
	@GetMapping("/User/{userId}/PBudgets")
	public HashMap<Long,Double> getUserPastBudgetLimits(@PathVariable long userId) {
		return userService.getUserPastBudgetLimits(userId);
	}
	@GetMapping("/User/{userId}/CBudget")
	public void getUserCurrentBudgetLimit(@PathVariable long userID) {

	}

	public void postCurrentBudgetLimit() {
		// TODO - implement userController.postCurrentBudgetLimit
		throw new UnsupportedOperationException();
	}

	public void changeCurrentBudgetLimit() {
		// TODO - implement userController.changeCurrentBudgetLimit
		throw new UnsupportedOperationException();
	}

}
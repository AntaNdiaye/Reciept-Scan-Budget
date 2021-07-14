package directory.services;

import directory.exceptions.receipt.ReceiptAlreadyExistsException;
import directory.exceptions.user.UserAlreadyExistsException;
import directory.exceptions.user.UserNotFoundException;
import directory.models.Receipt;
import directory.models.User;
import directory.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public UserService(){}

	public User createUser(User newUser) throws UserAlreadyExistsException {
		if (userRepo.existsById(newUser.getUserId())) {
			throw new ReceiptAlreadyExistsException(newUser.getUserId());
		}
		return userRepo.save(newUser);
	}

	public List<Receipt> getUserReciepts(long userId) throws UserNotFoundException {
	if(!userRepo.existsById(userId)){
		throw new UserNotFoundException(userId);
	}
	return getUserReciepts(userId);
	}

	public HashMap<Long,Double> getUserPastBudgetLimits(long userId) throws UserNotFoundException {
		if(!userRepo.existsById(userId)){
			throw new UserNotFoundException(userId);
		}
		return getUserPastBudgetLimits(userId);
	}

	public double getUserCurrentBudgetLimits(long userId) {
		if(!userRepo.existsById(userId)){
			throw new UserNotFoundException(userId);
		}
		return getUserCurrentBudgetLimits(userId);
	}

	public void changeCurrentBudgetLimits(User theUser,double newBudget) {
		if(!userRepo.existsById(theUser.getUserId())){
			throw new UserNotFoundException(theUser.getUserId());
		}
		theUser.setCurrentBudgetLimit(newBudget);
		theUser.setPastBudgetLimitMap(theUser.getPastBudgetLimitMap());
	}

//	public void postBudgetLimits(long userId,	double newBudget) {
//		if(!userRepo.existsById(userId)){
//			throw new UserNotFoundException(userId);
//		}
//
//	}

}
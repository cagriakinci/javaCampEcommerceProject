package eCommerceHomework.business.abstracts;

import eCommerceHomework.entities.concretes.User;

public interface UserService {
	void signUp(User user);
	void logIn(User user);
	void signUpWithGoogle(User user);
}

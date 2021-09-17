package eCommerceHomework.business.concretes;


import eCommerceHomework.business.abstracts.GmailCheckService;
import eCommerceHomework.business.abstracts.MailCheckService;
import eCommerceHomework.business.abstracts.UserCheckService;
import eCommerceHomework.business.abstracts.UserService;
import eCommerceHomework.core.GoogleService;
import eCommerceHomework.dataAccess.abstracts.UserDao;
import eCommerceHomework.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;
	MailCheckService mailCheckService;
	UserCheckService userCheckService;
	GoogleService googleService;
	GmailCheckService gmailCheckService;

	public UserManager(UserDao userDao, MailCheckService mailCheckService, UserCheckService userCheckService,
			GoogleService googleService, GmailCheckService gmailCheckService) {
		super();
		this.userDao = userDao;
		this.mailCheckService = mailCheckService;
		this.userCheckService = userCheckService;
		this.googleService = googleService;
		this.gmailCheckService = gmailCheckService;

	}

	@Override
	public void signUp(User user) {
		if (userCheckService.confirmation(user) == true) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + "sisteme eklendi.");
			mailCheckService.verificationMail(user.getMail());
			userDao.add(user);
		}

	}

	@Override
	public void logIn(User user) {
		mailCheckService.verificationLink(user.getMail());
		if (userDao.getMail(user.getMail()) && userDao.getMail(user.getMail()) == true) {
			System.out.println("Giriş başarılı.");
		} else {
			System.out.println("Giriş başarısız.");
		}

	}

	@Override
	public void signUpWithGoogle(User user) {
		if (gmailCheckService.confirmation(user) == true) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + "sisteme eklendi.");
			mailCheckService.verificationMail(user.getMail());
			userDao.add(user);
		}

	}

}

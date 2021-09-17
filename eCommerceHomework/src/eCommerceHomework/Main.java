package eCommerceHomework;

import eCommerceHomework.business.concretes.GmailCheckManager;
import eCommerceHomework.business.concretes.MailCheckManager;
import eCommerceHomework.business.concretes.UserCheckManager;
import eCommerceHomework.business.concretes.UserManager;
import eCommerceHomework.core.GoogleManagerAdapter;
import eCommerceHomework.dataAccess.concretes.HibernateUserDao;
import eCommerceHomework.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1,"�a�r�","AKINCI","cagri.akinci@outlook.com","123456");
		User user2 = new User(2,"�a�r�","AKINCI","abc.com","123456"); // E-posta hatas� verir.
		User user3 = new User(3,"�","AKINCI","cagri.akinci@outlook.com","123456"); // isim hatas� verir.
		User user4 = new User(4,"�a�r�","A","cagri.akinci@outlook.com","123456"); // soyisim hatas� verir.
		User user5 = new User(5,"�a�r�","AKINCI","cagri.akinci@outlook.com","123"); // �ifre hatas� verir.
		User user6 = new User(6,"�a�r�","AKINCI","abcfsdas@asdgmail.com","123456"); // gmail hatas� verir.
		
		UserManager userManager = new UserManager(new HibernateUserDao(),new MailCheckManager(), new UserCheckManager(), new GoogleManagerAdapter(), new GmailCheckManager());
		userManager.signUp(user1);
		userManager.signUp(user2); 
		userManager.signUp(user3);
		userManager.signUp(user4);
		userManager.signUp(user5);
		userManager.logIn(user1);
		userManager.signUpWithGoogle(user6);
	}

}

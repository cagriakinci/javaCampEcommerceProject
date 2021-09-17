package eCommerceHomework.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eCommerceHomework.business.abstracts.GmailCheckService;
import eCommerceHomework.entities.concretes.User;

public class GmailCheckManager implements GmailCheckService {
	List<String> mailList = new ArrayList<String>();

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Parola 6 karakterden az olamaz.");
			return false;
		} else if (user.getPassword().isEmpty()) {
			System.out.println("Parola bo� b�rak�lamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().length() < 2) {
			System.out.println("Ad�n�z 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().length() < 2) {
			System.out.println("Soyad�n�z 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkGmail(User user) {
		String regex = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(user.getMail()).find() == false) {
			System.out.println("Girdi�iniz mail g-mail format�nda de�il.");
			return false;
		} else if (user.getMail().isEmpty()) {
			System.out.println("Mail alan� bo� b�rak�lamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean mailIsValid(User user) {
		boolean result = true;
		if (mailList.contains(user.getMail())) {
			System.out.println("Bu mail ile daha �nce kay�t olunmu�. L�tfen ba�ka bir mail adresi giriniz.");
			result = false;
		} else {
			mailList.add(user.getMail());
			result = true;
		}
		return result;
	}

	@Override
	public boolean confirmation(User user) {
		if (checkFirstName(user) && checkLastName(user) && checkGmail(user) && checkPassword(user)
				&& mailIsValid(user) == true) {
			return true;
		}
		return false;
	}
}

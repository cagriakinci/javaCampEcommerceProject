package eCommerceHomework.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceHomework.dataAccess.abstracts.UserDao;
import eCommerceHomework.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile g�ncellendi : "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile silindi : "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public boolean getMail(String mail) {
		for (User user:users) {
			if(user.getMail()==mail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for(User user:users) {
			if(user.getPassword()==password) {
				return true;
			}
		}
		return false;
	}
	
	
}

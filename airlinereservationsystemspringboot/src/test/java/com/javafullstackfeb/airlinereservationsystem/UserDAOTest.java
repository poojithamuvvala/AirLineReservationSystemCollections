package com.javafullstackfeb.airlinereservationsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javafullstackfeb.airlinereservationsystem.bean.UserBean;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
	
	@Autowired
	private UserDAO dao;
	
	@Test
	public void registerTest() {
		UserBean userBean = new UserBean();
		userBean.setUserFirstName("Sujatha");
		userBean.setUserLastName("Goud");
		userBean.setUserEmail("srikanth@gmail.com");
		userBean.setUserContact(948284800);
		userBean.setUserId("Srikanth5");
		userBean.setUserPassword("srikanth123");
		userBean.setUserRole("admin");
		assertEquals(true, dao.registerByAdmin(userBean));
	}
	


}

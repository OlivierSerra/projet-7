package com.nnk.springboot;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void UserTest() {

		User user = new User("Titi","Oserra75", "Olivier_Serra", "USER");

		// Save
		user = userRepository.save(user);
		Assert.assertNotNull(user.getId());
		Assert.assertEquals("Titi", user.getUsername());
		Assert.assertEquals("Oserra75", user.getPassword());
		Assert.assertEquals("Olivier_Serra", user.getFullname());
		Assert.assertEquals("USER", user.getRole());

		//Read
		List<User> users =userRepository.findAll();
		Assert.assertTrue(users.size() >0);//non null

		Optional<User> identifiant = userRepository.findById(user.getId());
		Assert.assertEquals("Titi", identifiant.get().getUsername());

		// Update
		user.setFullname("Olivier S");
		user.setPassword("Oserra75");
		user.setRole("ADMIN");
		user = userRepository.save(user);

		Assert.assertEquals("Olivier S", user.getFullname());
		Assert.assertEquals("Oserra75", user.getPassword());
		Assert.assertEquals("ADMIN", user.getRole());

		// Find
		List<User> listResultat = userRepository.findAll();
		Assert.assertTrue(listResultat.size() > 0);

		// Delete
		Integer id = user.getId();
		userRepository.delete(user);
		Optional<User> userList = userRepository.findById(id);
		Assert.assertFalse(userList.isPresent());
	}
}

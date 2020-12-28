package com.jobs.management.config;

import org.springframework.batch.item.ItemProcessor;

import com.jobs.management.entity.User;

public class UserProcessor implements ItemProcessor<User, User> {

	@Override
	public User process(final User user) {

		final User user1 = new User();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		return user1;
	}

}

package com.jobs.management.config;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.jobs.management.entity.User;

/**
 * 
 * @author Srikanth
 *
 */
public class UserFieldSetMapper implements FieldSetMapper<User> {

	@Override
	public User mapFieldSet(FieldSet fieldSet) {
		final User user = new User();
		user.setFirstName(fieldSet.readString("firstName"));
		user.setLastName(fieldSet.readString("lastName"));
		return user;

	}

}

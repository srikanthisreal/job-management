package com.jobs.management.config;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jobs.management.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationListener extends JobExecutionListenerSupport {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public NotificationListener(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(final JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			jdbcTemplate
					.query("SELECT FIRSTNAME, LASTNAME FROM User", (u, row) -> new User(u.getString(1), u.getString(2)))
					.forEach(user -> log.info("Found User in the database FirstName-{}, LastName-{}",
							user.getFirstName(), user.getLastName()));
		}
	}
}

package com.nnk.springboot;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.RuleNameRepository;
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
public class RuleTests {

	@Autowired
	private RuleNameRepository ruleNameRepository;

	@Test
	public void ruleTest() {
		RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL Str", "SQL Part");

		// Save
		rule = ruleNameRepository.save(rule);
		Assert.assertNotNull(rule.getId());
		Assert.assertTrue(rule.getName().equals("Rule Name"));
		Assert.assertEquals("Rule Name", rule.getName());
		Assert.assertEquals("Description", rule.getDescription());
		Assert.assertEquals("Json", rule.getJson());
		Assert.assertEquals("Template", rule.getTemplate());
		Assert.assertEquals("SQL Str", rule.getSqlStr());
		Assert.assertEquals("SQL Part", rule.getSqlPart());

		// Update
		rule.setName("Rule Name Update");
		rule = ruleNameRepository.save(rule);
		Assert.assertEquals("Rule Name Update", rule.getName());

		//READ
		Optional<RuleName> newRule = ruleNameRepository.findById(rule.getId());
		Assert.assertTrue(newRule.isPresent());
		Assert.assertEquals("Rule Name Update", newRule.get().getName());
		Assert.assertEquals("Description", newRule.get().getDescription());
		Assert.assertEquals("Json", newRule.get().getJson());
		Assert.assertEquals("Template", newRule.get().getTemplate());
		Assert.assertEquals("SQL Str", newRule.get().getSqlStr());
		Assert.assertEquals("SQL Part", newRule.get().getSqlPart());

		// Find
		List<RuleName> listResult = ruleNameRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = rule.getId();
		ruleNameRepository.delete(rule);
		Assert.assertFalse(ruleNameRepository.findById(id).isPresent());
	}
}

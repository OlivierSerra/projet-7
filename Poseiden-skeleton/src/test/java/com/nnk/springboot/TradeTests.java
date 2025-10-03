package com.nnk.springboot;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
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
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;

	@Test
	public void tradeTest() {

		Trade trade = new Trade(1,"Trade Account", "Type", 1);

		// Save
		trade = tradeRepository.save(trade);
		Assert.assertNotNull(trade.getId());
		Assert.assertEquals("Trade Account", trade.getAccount());
		Assert.assertEquals("Type", trade.getType());
		Assert.assertEquals(1, trade.getBuyQuantity().intValue());

		//READ
		Optional<Trade> newIdentify = tradeRepository.findById(trade.getId());
		Assert.assertTrue(newIdentify.isPresent());

		Trade tradeUploaded= newIdentify.get();
		Assert.assertEquals("Trade Account", tradeUploaded.getAccount());
		Assert.assertEquals("Type", tradeUploaded.getType());
		Assert.assertEquals(1, tradeUploaded.getBuyQuantity().intValue());

		// Update
		trade.setAccount("Trade Account Update");
		trade.setType("Type Update");
		trade.setBuyQuantity(2);

		Trade newTrade= tradeRepository.save(trade);//lecture après avoir relancé
		Assert.assertEquals("Trade Account Update", newTrade.getAccount());
		Assert.assertEquals("Type Update", newTrade.getType());
		Assert.assertEquals(2, newTrade.getBuyQuantity().intValue());

		// Find
		List<Trade> listResult = tradeRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = trade.getId();
		tradeRepository.delete(trade);
		Optional<Trade> tradeList = tradeRepository.findById(id);
		Assert.assertFalse(tradeList.isPresent());
	}
}

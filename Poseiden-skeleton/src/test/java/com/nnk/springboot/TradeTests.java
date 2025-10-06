package com.nnk.springboot;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;

	@Test
	public void tradeTest() {

		Trade trade = new Trade(1, "ACC-1234", "Equity", 100, 0.0, 152.75,
				0.0, "S&P500",
				LocalDate.of(2025, 10, 6), "AAPL", "Open", "Olivier Serra",
				"Book-XYZ",
				"System", LocalDate.of(2025, 10, 6),
				"Olivier Serra",
				LocalDate.of(2025, 10, 6), "Deal-2025-01", "Buy",
				"SRC-001", "Buy");

		// Save
		trade = tradeRepository.save(trade);
		Assert.assertNotNull(trade.getId());
		Assert.assertEquals("ACC-1234", trade.getAccount());
		Assert.assertEquals("Equity", trade.getType());
		Assert.assertEquals(100, trade.getBuyQuantity().intValue());
		Assert.assertEquals(0.0, trade.getSellQuantity(), 0.01);
		Assert.assertEquals(152.75, trade.getBuyPrice(), 0.02);
		Assert.assertEquals(0.0, trade.getSellPrice(), 0.01);
		Assert.assertEquals("S&P500", trade.getBenchmark());
		Assert.assertEquals(LocalDate.of(2025, 10, 6), trade.getTradeDate());
		Assert.assertEquals("AAPL", trade.getTradeDate());
		Assert.assertEquals("Open", trade.getStatus());
		Assert.assertEquals("Olivier Serra", trade.getTrader());
		Assert.assertEquals("Book-XYZ", trade.getBook());
		Assert.assertEquals("System", trade.getCreationName());
		Assert.assertEquals(LocalDate.of(2025, 10, 6), trade.getCreationDate());
		Assert.assertEquals("Olivier Serra", trade.getRevisionName());
		Assert.assertEquals(LocalDate.of(2025, 10, 6), trade.getRevisionDate());
		Assert.assertEquals("Deal-2025-01", trade.getDealName());
		Assert.assertEquals("Buy", trade.getDealType());
		Assert.assertEquals("SRC-001", trade.getSourceListId());
		Assert.assertEquals("Buy", trade.getSide());

		//READ
		Optional<Trade> newIdentify = tradeRepository.findById(trade.getId());
		Assert.assertTrue(newIdentify.isPresent());

		Trade tradeUploaded= newIdentify.get();
		Assert.assertEquals("ACC-1234", tradeUploaded.getAccount());
		Assert.assertEquals("Equity", tradeUploaded.getType());
		Assert.assertEquals(100, tradeUploaded.getBuyQuantity().intValue());
		Assert.assertEquals("Type", tradeUploaded.getType());
		Assert.assertEquals("ACC-1234", tradeUploaded.getAccount());
		Assert.assertEquals("Equity", tradeUploaded.getType());
		Assert.assertEquals(100, tradeUploaded.getBuyQuantity().intValue());
		Assert.assertEquals(0.0, tradeUploaded.getSellQuantity());
		Assert.assertEquals(152.75, tradeUploaded.getBuyPrice());
		Assert.assertEquals(0.0, tradeUploaded.getSellPrice());
		Assert.assertEquals("S&P500", tradeUploaded.getBenchmark());
		Assert.assertEquals(LocalDate.of(2025, 10, 6), tradeUploaded.getTradeDate());
		Assert.assertEquals("AAPL", tradeUploaded.getSecurity());
		Assert.assertEquals("Open", tradeUploaded.getStatus());
		Assert.assertEquals("Olivier Serra", tradeUploaded.getTrader());
		Assert.assertEquals("Book-XYZ", tradeUploaded.getBook());
		Assert.assertEquals("System", tradeUploaded.getCreationName());
		Assert.assertEquals(LocalDate.of(2025, 10, 6), tradeUploaded.getCreationDate());
		Assert.assertEquals("Olivier Serra", tradeUploaded.getRevisionName());
		Assert.assertEquals(LocalDate.of(2025, 10, 6), tradeUploaded.getRevisionDate());
		Assert.assertEquals("Deal-2025-01", tradeUploaded.getDealName());
		Assert.assertEquals("Buy", tradeUploaded.getDealType());
		Assert.assertEquals("SRC-001", tradeUploaded.getSourceListId());
		Assert.assertEquals("Buy", tradeUploaded.getSide());


		// Update
		trade.setAccount("ACC-9999");
		trade.setType("actions");
		trade.setBuyQuantity(200);
		trade.setSellQuantity(0.0);
		trade.setBuyPrice(152);
		trade.setSellPrice(2.0);
		trade.setBenchmark("CAC40");
		trade.setTradeDate(LocalDate.of(2025, 10, 5));
		trade.setSecurity("AAPC");
		trade.setStatus("Close");
		trade.setTrader("Sylvie Serra");
		trade.setBook("Book-TUV");
		trade.setCreationName("System");
		trade.setCreationDate(LocalDate.of(2025, 10, 5));
		trade.setRevisionName("Sylvie Serra");
		trade.setRevisionDate(LocalDate.of(2025, 10, 5));
		trade.setDealName("Deal-2025-02");
		trade.setDealType("sell");
		trade.setSourceListId("SRC-002");
		trade.setSide("Sell");

		Trade newTrade= tradeRepository.save(trade);//lecture après avoir relancé
		Assert.assertEquals("ACC-9999", newTrade.getAccount());
		Assert.assertEquals("actions", newTrade.getType());
		Assert.assertEquals(200, newTrade.getBuyQuantity().intValue());
		Assert.assertEquals(0.0, newTrade.getSellQuantity());
		Assert.assertEquals(152, newTrade.getBuyPrice());
		Assert.assertEquals(2.0, newTrade.getSellPrice());
		Assert.assertEquals("CAC40", newTrade.getBenchmark());
		Assert.assertEquals(LocalDate.of(2025, 10, 5), newTrade.getTradeDate());
		Assert.assertEquals("AAPC", newTrade.getSecurity());
		Assert.assertEquals("Close", newTrade.getStatus());
		Assert.assertEquals("Sylvie Serra", newTrade.getTrader());
		Assert.assertEquals("Book-TUV", newTrade.getBook());
		Assert.assertEquals("System", newTrade.getCreationName());
		Assert.assertEquals(LocalDate.of(2025, 10, 5), newTrade.getCreationDate());
		Assert.assertEquals("Sylvie Serra", newTrade.getRevisionName());
		Assert.assertEquals(LocalDate.of(2025, 10, 5), newTrade.getRevisionDate());
		Assert.assertEquals("Deal-2025-02", newTrade.getDealName());
		Assert.assertEquals("Sell", newTrade.getDealType());
		Assert.assertEquals("SRC-002", newTrade.getSourceListId());
		Assert.assertEquals("Sell", newTrade.getSide());

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

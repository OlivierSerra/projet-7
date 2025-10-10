package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidListTests {

	@Autowired
	private BidListRepository bidListRepository;

	DateTimeFormatter FR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Test
	public void bidListTest() {
		//BidList bid = new BidList("Account Test", "Type Test", 10d,);
		//null : je veux garder un seul constructeur et le contrusteur prend bidListId et là non
		BidList bid = new BidList(
				null,
				"ACC-56789",
				"Bond",
				50000.00,
				52000.00,
				101.25,
				101.75,
				"EURIBOR",
				LocalDate.parse("02/10/2025", FR),
				"Corporate bond client interest",
				"CORP-BOND-EUR",
				"Pending",
				"Alice Smith",
				"FixedIncome",
				"adminUser",
				LocalDate.parse("02/10/2025", FR),
				"reviewBot",
				LocalDate.parse("03/10/2025", FR),
				"Bond_Deal_2025",
				"Corporate Bond",
				"84",
				"Sell"
		);

		// Save
		bid = bidListRepository.save(bid);
		Assert.assertNotNull(bid.getBidListId());
		Assert.assertEquals(bid.getBidQuantity(), 50000, 0.01);
		//Assert.assertEquals("Account Test", bid.getAccount());
		//Assert.assertEquals("Type Test", bid.getType());
		//Assert.assertEquals(10d, bid.getBidQuantity(), 0.001);

		Assert.assertEquals("ACC-56789", bid.getAccount());
		Assert.assertEquals("Bond", bid.getType());
		Assert.assertEquals(50000.00, bid.getBidQuantity(), 0.001);
		Assert.assertEquals(52000.00, bid.getAskQuantity(), 0.001);
		Assert.assertEquals(101.25, bid.getBid(), 0.001);
		Assert.assertEquals(101.75, bid.getAsk(), 0.001);
		Assert.assertEquals("EURIBOR", bid.getBenchmark());
		Assert.assertEquals(LocalDate.parse("02/10/2025", FR), bid.getBidListDate());
		Assert.assertEquals("Corporate bond client interest", bid.getCommentary());
		Assert.assertEquals("CORP-BOND-EUR", bid.getSecurity());
		Assert.assertEquals("Pending",bid.getStatus());
		Assert.assertEquals("Alice Smith", bid.getTrader());
		Assert.assertEquals("FixedIncome", bid.getBook());
		Assert.assertEquals("adminUser", bid.getCreationName());
		Assert.assertEquals(LocalDate.parse("02/10/2025", FR), bid.getCreationDate());
		Assert.assertEquals("reviewBot", bid.getRevisionName());
		Assert.assertEquals(LocalDate.parse("03/10/2025", FR), bid.getRevisionDate());
		Assert.assertEquals("Bond_Deal_2025", bid.getDealName());
		Assert.assertEquals("Corporate Bond", bid.getDealType());
		Assert.assertEquals("84", bid.getSourceListId());
		Assert.assertEquals("Sell", bid.getSide());

		//Read
		//List<BidList> bids = bidListRepository.findAll();
		//Assert.assertTrue(bids.size() >0);//non null

		Optional<BidList> identifiant = bidListRepository.findById(bid.getBidListId());
		Assert.assertTrue(identifiant.isPresent());
		BidList newBidList = identifiant.get();
		Assert.assertEquals("ACC-56789", newBidList.getAccount());
		Assert.assertEquals("Bond", newBidList.getType());
		Assert.assertEquals(50000.00, newBidList.getBidQuantity(), 0.001);
		Assert.assertEquals(52000.00, newBidList.getAskQuantity(), 0.001);
		Assert.assertEquals(101.25, newBidList.getBid(), 0.001);
		Assert.assertEquals(101.75, newBidList.getAsk(), 0.001);
		Assert.assertEquals("EURIBOR", newBidList.getBenchmark());
		Assert.assertEquals(LocalDate.parse("02/10/2025", FR), newBidList.getBidListDate());
				Assert.assertEquals("Corporate bond client interest", newBidList.getCommentary());
		Assert.assertEquals("CORP-BOND-EUR", newBidList.getSecurity());
		Assert.assertEquals("Pending",newBidList.getStatus());
		Assert.assertEquals("Alice Smith", newBidList.getTrader());
		Assert.assertEquals("FixedIncome", newBidList.getBook());
		Assert.assertEquals("adminUser", newBidList.getCreationName());
		Assert.assertEquals(LocalDate.parse("02/10/2025", FR), newBidList.getCreationDate());
		Assert.assertEquals("reviewBot", newBidList.getRevisionName());
		Assert.assertEquals(LocalDate.parse("03/10/2025", FR), newBidList.getRevisionDate());
		Assert.assertEquals("Bond_Deal_2025", newBidList.getDealName());
		Assert.assertEquals("Corporate Bond", newBidList.getDealType());
		Assert.assertEquals("84", newBidList.getSourceListId());
		Assert.assertEquals("Sell", newBidList.getSide());

		// Update
		newBidList.setBidQuantity(20);
		newBidList = bidListRepository.save(newBidList);
		Assert.assertEquals(20.0, newBidList.getBidQuantity(), 0.01);


		// Find
		List<BidList> listResult = bidListRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getBidListId();
		bidListRepository.delete(bid);
		Assert.assertFalse(bidListRepository.findById(id).isPresent());
	}
}

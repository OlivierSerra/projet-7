package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.BidListRepository;
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
public class BidTests {

	@Autowired
	private BidListRepository bidListRepository;

	@Test
	public void bidListTest() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListRepository.save(bid);
		Assert.assertNotNull(bid.getBidListId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);
		Assert.assertEquals("Account Test", bid.getAccount());
		Assert.assertEquals("Type Test", bid.getType());
		Assert.assertEquals(10d, bid.getBidQuantity(), 0.001);

		//Read
		//List<BidList> bids = bidListRepository.findAll();
		//Assert.assertTrue(bids.size() >0);//non null

		Optional<BidList> identifiant = bidListRepository.findById(bid.getBidListId());
		Assert.assertTrue(identifiant.isPresent());
		BidList newBidList = identifiant.get();
		Assert.assertEquals("Account Test", newBidList.getAccount());
		Assert.assertEquals("Type Test", newBidList.getType());
		Assert.assertEquals(10d, newBidList.getBidQuantity(), 0.01);

		// Update
		newBidList.setBidQuantity(20d);
		newBidList = bidListRepository.save(newBidList);
		Assert.assertEquals("20d", newBidList.getBidQuantity(), 20d, 20d);

		bid = bidListRepository.save(bid);

		// Find
		List<BidList> listResult = bidListRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getBidListId();
		bidListRepository.delete(bid);
		Assert.assertFalse(bidListRepository.findById(id).isPresent());
	}
}

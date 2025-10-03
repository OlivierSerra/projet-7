package com.nnk.springboot;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.RatingRepository;
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
public class RatingTests {

	@Autowired
	private RatingRepository ratingRepository;

	@Test
	public void ratingTest() {
		Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);

		// Save
		rating = ratingRepository.save(rating);
		Assert.assertNotNull(rating.getId());

		Assert.assertEquals(10, rating.getOrderNumber());
		Assert.assertEquals("Moodys Rating", rating.getMoodysRating());
		Assert.assertEquals("Sand PRating", rating.getSandPRating());
		Assert.assertEquals("Fitch Rating", rating.getFitchRating());

		//Read
		//List<Rating> ratings = ratingRepository.findAll();
		//Assert.assertTrue(ratings.size() >0);//non null

		Optional<Rating> newIdentifiant = ratingRepository.findById(rating.getId());
		Assert.assertTrue(newIdentifiant.isPresent());
		Rating newRating= newIdentifiant.get();
		Assert.assertEquals("Moodys Rating", newRating.getMoodysRating());
		Assert.assertEquals("Sand PRating", newRating.getSandPRating());
		Assert.assertEquals("Fitch Rating", newRating.getFitchRating());
		Assert.assertEquals(10, newRating.getOrderNumber());

		// Update
		rating.setOrderNumber(20);
		rating.setMoodysRating("Moodys Rating");
		rating.setSandPRating("Sand PRating");
		rating.setFitchRating("Fitch Rating");
		Rating ratingUploaded= ratingRepository.save(rating);

		Assert.assertEquals(20, ratingUploaded.getOrderNumber());
		Assert.assertEquals("Moodys Rating", ratingUploaded.getMoodysRating());
		Assert.assertEquals("Sand PRating", ratingUploaded.getSandPRating());
		Assert.assertEquals("Fitch Rating", ratingUploaded.getFitchRating());

		// Find
		List<Rating> listResult = ratingRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = rating.getId();
		ratingRepository.delete(rating);
		Assert.assertFalse(ratingRepository.findById(id).isPresent());
	}
}

package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {

	@Autowired
	private CurvePointRepository curvePointRepository;

	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = new CurvePoint(10, 100, 300, LocalDate.of(4, 10, 2025));

		// Save
		curvePoint = curvePointRepository.save(curvePoint);
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);
		Assert.assertEquals(10, curvePoint.getCurveId().intValue());
		Assert.assertEquals(10d, curvePoint.getTerm(), 0.01);
		Assert.assertEquals(30d, curvePoint.getValue(), 0.01);

		//Read
		//List<CurvePoint> curvePoints = curvePointRepository.findAll();
		//Assert.assertTrue(curvePoints.size() >0);//non null

		Optional<CurvePoint> newIdentifiant = curvePointRepository.findById(curvePoint.getId());
		Assert.assertTrue(newIdentifiant.isPresent());
		CurvePoint newCurvePoint = newIdentifiant.get();
		Assert.assertEquals(10d, newCurvePoint.getTerm(), 0.01);
		Assert.assertEquals(30d, newCurvePoint.getValue(), 0.01);

		// Update
		newCurvePoint.setCurveId(20);
		newCurvePoint = curvePointRepository.save(curvePoint);
		Assert.assertEquals(10, newCurvePoint.getCurveId().intValue());

		newCurvePoint.setTerm(10d);
		newCurvePoint.setValue(30d);
		newCurvePoint = curvePointRepository.save(curvePoint);

		Assert.assertEquals(10d, newCurvePoint.getTerm(), 0.01);
		Assert.assertEquals(30d, curvePoint.getValue(), 0.01);

		// Find
		List<CurvePoint> listResult = curvePointRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = curvePoint.getId();
		curvePointRepository.delete(curvePoint);
		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
		Assert.assertFalse(curvePointList.isPresent());
	}

}

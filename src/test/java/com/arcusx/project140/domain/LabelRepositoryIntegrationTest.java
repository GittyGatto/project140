package com.arcusx.project140.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class LabelRepositoryIntegrationTest {

	@Autowired
	LabelRepository labelRepository;
	
	private static final String LABELTEXT = "LabelTestText";
	private static final Date LABELDATE = new Date();

	@Test
	public void saveLabelTest() {
		// given
		Label label = createLabelMock(LABELTEXT, LABELDATE);
		// when
		labelRepository.save(label);
		Long labelId = label.getLabelId();
		// then
		Label result = labelRepository.findOne(labelId);
		assertNotNull(result);
		assertEquals(labelId, result.getLabelId());
		assertEquals(LABELTEXT, result.getLabelText());
		assertEquals(LABELDATE, result.getLabelDate());
	}

	@Test
	public void updateLabelTest() {
		// given
		Label label = createLabelMock(LABELTEXT, LABELDATE);
		labelRepository.save(label);
		// when
		label.setLabelText("updatedLabelText");
		Calendar c = Calendar.getInstance();
		c.setTime(LABELDATE);
		c.add(Calendar.YEAR, -36);
		Date newLabelDate = c.getTime();
		label.setLabelDate(newLabelDate);
		Label result = labelRepository.save(label);
		// then
		assertNotNull(result);
		assertEquals("updatedLabelText", result.getLabelText());
		assertEquals(newLabelDate, result.getLabelDate());
	}

	@Test
	public void deleteLabel() {
		// given
		Label label = createLabelMock(LABELTEXT, LABELDATE);
		labelRepository.save(label);
		Long labelId = label.getLabelId();
		// when
		labelRepository.delete(labelId);
		// then
		try {
			labelRepository.findOne(labelId);
			fail("Expected EmptyResultDataAccessException caused by NoResultException, but non caught.");
		} catch (Exception ex) {
			assertTrue((ex instanceof EmptyResultDataAccessException));
		}
	}

	@Test
	public void getAllLabels() {
		// given
		// when
		Iterable<Label> allLabels = labelRepository.findAll();
		// then
		assertNotNull(allLabels);
	}

	@Test
	public void getLabel() {
		// given
		Label label = createLabelMock(LABELTEXT, LABELDATE);
		labelRepository.save(label);
		Long labelId = label.getLabelId();
		// when
		Label result = labelRepository.findOne(labelId);
		// then
		assertNotNull(result);
		assertEquals(labelId, result.getLabelId());
		assertEquals(LABELTEXT, result.getLabelText());
		assertEquals(LABELDATE, result.getLabelDate());
	}

	private Label createLabelMock(String labelText, Date labelDate) {
		Label label = new Label();
		label.setLabelText(labelText);
		label.setLabelDate(labelDate);
		return label;
	}
}

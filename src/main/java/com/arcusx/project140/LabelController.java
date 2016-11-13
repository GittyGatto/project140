package com.arcusx.project140;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arcusx.project140.businessService.LabelBusinessService;
import com.arcusx.project140.domain.Label;

@RestController
public class LabelController {
	@Autowired
	private LabelBusinessService labelBusinessService;

	@RequestMapping(value = "/label", method = RequestMethod.POST)
	public Label saveLabel(@RequestBody Label label) {
		labelBusinessService.saveLabel(label);
		return label;
	}

	@RequestMapping(value = "/label", method = RequestMethod.PUT)
	public void updateLabel(@RequestBody Label label) {
		labelBusinessService.updateLabel(label);
	}

	@RequestMapping(value = "/label", method = RequestMethod.GET)
	public List<Label> getAllLabels() {
		return labelBusinessService.getAllLabels();
	}

	@RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
	public Label getLabel(@PathVariable("id") Long labelId) {
		return labelBusinessService.getLabel(labelId);
	}

	@RequestMapping(value = "/label/{id}", method = RequestMethod.DELETE)
	public void deleteLabel(@PathVariable("id") Long labelId) {
		labelBusinessService.deleteLabel(labelId);
	}
}

package com.arcusx.project140.businessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcusx.project140.domain.Label;
import com.arcusx.project140.domain.LabelRepository;

@Service
public class LabelBusinessService {
	@Autowired
	private LabelRepository labelRepository;

	public void saveLabel(Label label) {
		labelRepository.save(label);
	}

	public void updateLabel(Label label) {
		labelRepository.save(label);
	}

	public Label getLabel(Long labelId) {
		return labelRepository.findOne(labelId);
	}

	public List<Label> getAllLabels() {
		return (List<Label>)labelRepository.findAll();
	}

	public void deleteLabel(Long labelId) {
		labelRepository.delete(labelId);
	}
}

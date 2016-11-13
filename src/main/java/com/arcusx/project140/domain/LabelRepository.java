package com.arcusx.project140.domain;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
	
	Label findLabelByLabelDate(Date date);
}

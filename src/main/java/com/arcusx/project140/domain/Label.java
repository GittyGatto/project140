package com.arcusx.project140.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "label")
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "label_idSeq")
	@SequenceGenerator(name = "label_idSeq", sequenceName = "label_label_id_seq", allocationSize = 1)
	@Column(name = "label_id", nullable = false)
	private Long labelId;

	@Column(name = "label_text")
	private String labelText;

	@Column(name = "label_date")
	@Temporal(TemporalType.DATE)
	private Date labelDate;

	public Long getLabelId() {
		return this.labelId;
	}

	public String getLabelText() {
		return this.labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public Date getLabelDate() {
		return this.labelDate;
	}

	public void setLabelDate(Date labelDate) {
		this.labelDate = labelDate;
	}	
}
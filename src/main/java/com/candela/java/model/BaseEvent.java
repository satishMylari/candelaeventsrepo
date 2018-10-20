package com.candela.java.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Entity
@Data
public class BaseEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id ;
	private String methodName;
	private String eventInitiator;
	private String timeOfEvent;
}

package com.candela.java.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class CheckoutEvent extends BaseEvent{
 private String comments;
}

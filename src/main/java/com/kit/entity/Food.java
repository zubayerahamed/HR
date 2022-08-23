package com.kit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 23, 2022
 */
@Data
@Entity
@Table(name = "FOOD")
public class Food implements Serializable {

	private static final long serialVersionUID = 4461678541270017602L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;

	private boolean present;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String month;
	private String year;
}

package com.kit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Data
@Entity
@Table(name = "GRADE")
public class Grade implements Serializable{

	private static final long serialVersionUID = 4409270696225228334L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String code;
	private boolean status;
}

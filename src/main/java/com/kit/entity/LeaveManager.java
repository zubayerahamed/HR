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
 * @since Aug 27, 2022
 */
@Data
@Entity
@Table(name = "LEAVE_MANAGER")
public class LeaveManager implements Serializable {

	private static final long serialVersionUID = 6501573904439432225L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;

	private String year;
	private int totalAllocatedLeave;
	private int alreadyTaken;
	private int annual;
	private int casual;
	private int sick;
	private int approved;
	private int notApproved;
}

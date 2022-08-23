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
@Table(name = "US")
public class User implements Serializable{

	private static final long serialVersionUID = -2122661616580934825L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String username;
	private String password;
	private boolean status;
}

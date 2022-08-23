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
 * @since Aug 22, 2022
 */
@Data
@Entity
@Table(name = "DOCUMENT")
public class Document implements Serializable {

	private static final long serialVersionUID = 3488467748751492194L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String type;
	private String bucketName;
	private String fileDir;
	@Temporal(TemporalType.DATE)
	private Date date;
	private boolean status;
}

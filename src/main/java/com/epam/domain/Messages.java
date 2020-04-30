package com.epam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="MESSAGES")
public class Messages {
	
	@Id
    @GeneratedValue
	String id;
	
	@Column(name="data")
	String data;

}

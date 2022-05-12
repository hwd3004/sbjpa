package com.example.sbjpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Builder
public class Temp1 {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int board_seq;
	private String title;
	private String contents;
	private Date reg_date;
}

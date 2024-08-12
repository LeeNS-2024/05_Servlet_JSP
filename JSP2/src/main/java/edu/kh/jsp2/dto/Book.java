package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // == Getter/Setter/ ToString 포함되어있음
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private String title;
	private String writer;
	private int    price;
}

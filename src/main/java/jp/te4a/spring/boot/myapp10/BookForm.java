package jp.te4a.spring.boot.myapp10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Entity
//@Table(name="book_seq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
	//@Id
	private Integer id;
	private String title;
	private String writter;
	private String publisher;
	private Integer price;
}

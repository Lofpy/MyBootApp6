package jp.te4a.spring.boot.myapp10;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
	@Id
	@GeneratedValue
	Integer id;
	@Column(nullable=false)
	String title;
	String writter;
	String publisher;
	Integer price;
}

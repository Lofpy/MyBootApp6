package jp.te4a.spring.boot.myapp13.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.te4a.spring.boot.myapp13.validate.WritterValid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookForm {
	private Integer id;
	@NotNull
	@Size(min = 3)
	private String title;
	@WritterValid(ok = "東北タロウ")
    @Size(min = 3, max = 20)
	private String writter;
	private String publisher;
	@Min(0)
	private Integer price;
}
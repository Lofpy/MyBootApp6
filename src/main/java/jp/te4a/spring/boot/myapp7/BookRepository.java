package jp.te4a.spring.boot.myapp7;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.ArrayList;
@Repository
public class BookRepository {
	private final ConcurrentMap<Integer, BookBean>BookMap
	=new ConcurrentHashMap<>();
	
	public BookBean save(BookBean bookBean) {
		return BookMap.put(bookBean.getId(), bookBean);
	}
	public void delete(Integer bookId) {
		BookMap.remove(bookId);
	}
	public List<BookBean>findAll(){
		return new ArrayList<>(BookMap.values());
	}
}

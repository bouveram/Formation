import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.m2i.formation.media.*;

public class CollectionTest {
	
	public List<Book> listTest() {
		
		List<Book> liste = new ArrayList<Book>();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		
		b1.setName("Premier Livre");
		b2.setName("Deuxieme Livre");
		b3.setName("Troisieme Livre");
		b4.setName("Quatrieme Livre");
		
		liste.add(b1);
		liste.add(b2);
		liste.add(b3);
		liste.add(1, b4);
		
		liste.remove(2);
		
		return liste;
	}
	
	public Set<Book> setTest() {
		Set<Book> set = new HashSet<Book>();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		
		b1.setName("Premier Livre");
		b2.setName("Deuxieme Livre");
		b3.setName("Troisieme Livre");
		b4.setName("Quatrieme Livre");
		
		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b1);
		
		set.remove(b2);
		
		return set;
	}
	
	public Map<String,Book> mapTest() {
		Map<String,Book> map = new HashMap<String,Book>();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		
		b1.setName("Premier Livre");
		b2.setName("Deuxieme Livre");
		b3.setName("Troisieme Livre");
		b4.setName("Quatrieme Livre");
		
		map.put("one", b1);
		map.put("two", b2);
		map.put("three", b3);
		map.put("four", b1);
		
		map.remove("four");
		
		return map;
	}
}

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
	
	public Map<Integer,Book> mapTest() {
		Map<Integer,Book> map = new HashMap<Integer,Book>();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		
		b1.setName("Premier Livre");
		b1.setId(1);
		b2.setName("Deuxieme Livre");
		b2.setId(2);
		b3.setName("Troisieme Livre");
		b3.setId(3);
		b4.setName("Quatrieme Livre");
		b3.setId(4);
				
		map.put(b1.getId(), b1);
		map.put(b2.getId(), b2);
		map.put(b3.getId(), b3);
		map.put(b4.getId(), b1);
		
		map.remove("four");
		
		return map;
	}
}

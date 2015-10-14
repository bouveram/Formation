import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.m2i.formation.media.entities.Book;

public class TestFile {
	
	public void readFile(String uri) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		String value;
		line = br.readLine();
		while(line!=null) {
						
			StringTokenizer st = new StringTokenizer(line,";");
			System.out.println(st.countTokens());
			int iteration = st.countTokens();
			for(int i=0; i < iteration;i++) {
				value = st.nextToken();
				System.out.print(value + ",");
			}
			
			System.out.println();
			line = br.readLine();
		}
		br.close();
	}
	
	public List<Book> readBooks(String uri) throws IOException {
		
		List<Book> bookList = new ArrayList<Book>();
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		line = br.readLine(); //delete first Line
		line = br.readLine();
		while(line!=null) {
			Book b = new Book();
			StringTokenizer st = new StringTokenizer(line,";");
			b.setTitle(st.nextToken());
			b.setNbPage(Integer.parseInt(st.nextToken()));
			b.setPrice(Double.parseDouble(st.nextToken()));
			bookList.add(b);
			line = br.readLine();
		}
		br.close();
		return bookList;
	}
}

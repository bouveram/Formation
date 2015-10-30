import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import com.m2i.formation.geometry.*;
import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.BookRepository;

public class Hello {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i=4;
		int j=9;

		System.out.println("i = " + i);
		System.out.println("j = " + j);
		int toto = i;
		i=j;
		j=toto;
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		System.out.println("Ta mere en short !");
		for (i = 0; i<100; i++) {
			System.out.println(i);
		}
		
		for(i = 10; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("BOOM !");
		
		j = 1;
		do {
			j*=2;
			System.out.println(j);
		} while(j<1024);
		
		System.out.println(add(5,4));
		
		int[] tab = {1,3,5,7,8,147,13,15,17,19};
		
		display(tab);
		System.out.println("Somme : "+tabSum(tab));
		System.out.println("Max : "+maximum(tab));
		System.out.println("Moyenne : "+average(tab));
		
		int[] randomedTab = new int[10];
		randomedTab = randomTab(10);
	    display(randomedTab);
	    System.out.println("Moyenne : "+average(randomedTab));
	    
	    System.out.println("new tab : {1,2,3,4,5}");
	    int[] tab2 = {1,2,3,4,5};
	    System.out.println("put : ");
	    display(put(tab2,2,99));
	    System.out.println("permut : ");
	    display(permut(tab2,1,3));
	    System.out.println("permut2 : ");
	    display(permut2(tab2,4));
	    System.out.println("remove : ");
	    display(remove(tab2,3));
	    System.out.println("insert : ");
	    display(insert(tab2,1,99));
	    
	    Book premierLivre = new Book();
	    Book deuxiemeLivre = new Book();
        Editor editeur = new Editor();
        editeur.setName("Edition M2i");
        
        Author guillaume = new Author();
        Author arthur = new Author();
        Author maurice = new Author();
        
        guillaume.setFirstName("Guillaume");
        guillaume.setLastName("Tel");
        
        arthur.setFirstName("Arthur");
        arthur.setLastName("Le Roi");
        
        maurice.setFirstName("Maurice");
        maurice.setLastName("Momo");
        
	    premierLivre.setTitle("Java");
	    premierLivre.setPublisher(editeur);
	    
	    //Gestion erreur
	    try {
			premierLivre.addAuthor(arthur);
		    premierLivre.addAuthor(guillaume);
		    
		    deuxiemeLivre.addAuthor(maurice);
	    } catch (MediaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(premierLivre.getTitle());
	    System.out.println("nom de l'editeur : "+ premierLivre.getPublisher().getName() );
	    
	    deuxiemeLivre.setTitle( premierLivre.getTitle() );
	    
	    premierLivre.displayAuthor();	    
	    
	    //deuxiemeLivre = premierLivre;
	    
	    if(premierLivre == deuxiemeLivre)
	    	System.out.println("c'est les mêmes livres");
	    else
	    	System.out.println("c'est pas les mêmes livres");
	    
	    /*Counter c1 = new Counter();
	    System.out.println(c1.increment());
	    System.out.println(c1.increment());
	    System.out.println(c1.increment());
	    Counter c2 = new Counter();
	    System.out.println(c2.increment());
	    System.out.println(c2.increment());
	    System.out.println(c2.increment());*/
	    
	    System.out.println(Counter.increment());
	    
	    premierLivre.setCategory(BookCategory.NOVEL);
	    System.out.println(premierLivre.getCategory());
	    
	    Point3D p3d = new Point3D();
	    p3d.setX(8);
	    
	    Media b2 = new Book();
	    b2.setPrice(100.0);
	    Book b3 = (Book)b2; //Permet de retrouver le nombre de pages
	    b3.getNbPage();
	    //ou :
	    int nbPage = ((Book)b2).getNbPage();
	    System.out.println(b2.getVATPrice());
	    
	    List<Book> liste = new ArrayList<Book>();
	    liste = new CollectionTest().listTest();
	    
	    for(Book b:liste){
	    	System.out.println(b.getName());
	    }
	    System.out.println();
	    Set<Book> set = new HashSet<Book>();
	    set = new CollectionTest().setTest();
	    
	    for(Book b:set){
	    	System.out.println(b.getName());
	    }
	    System.out.println();
	    Map<Integer,Book> map = new HashMap<Integer,Book>();
	    map = new CollectionTest().mapTest();
	    Book b = map.get(1);
	    for(int key : map.keySet()){
	    	System.out.println(b.getName());
	    }
	    
	    Cart cart = new Cart();
	    cart.getMedias().add(premierLivre);
	    
	    BookRepository fichier = new BookRepository();
	    fichier.setUri("C:\\Users\\adminlocal\\git\\Java\\Livres.csv");
	    liste = fichier.getAll();
	    for(Book bForEach:liste){
	    	System.out.println(bForEach.getTitle());
	    }
	    	    
	    liste = fichier.getByPrice(75.0);

	    for(Book bForEach:liste){
	    	System.out.println(bForEach.getTitle());
	    }
	    
	    liste = fichier.getByTitle("emile");
	    
	    for(Book bForEach:liste){
	    	System.out.println(bForEach.getTitle());
	    }
	    
	    cart.getMedias().addAll(liste);
	    System.out.println(cart.getVATPrice());
	    
	    Singleton singleton = Singleton.getInstance();
	    
	    
		
	    Connection conn = null;
		String strSQL = "UPDATE `test`.`media` SET `title`='La cigale et la fourmie' WHERE `id`='3';";
		
		//Properties, fichier de configuration
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream("src/test.properties"));
		} catch (IOException e) {
			
		}
		
		for(String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			System.out.println(key + " =>" + value);
		}
				
		try {
			// 1 : connection
			System.out.println("Connecting ...");
			conn = DriverManager.getConnection(	properties.getProperty("JDBC_URL"),
												properties.getProperty("JDBC_USER"),
												properties.getProperty("JDBC_PASS"));
			
			// 2
			System.out.println("Create statement ...");
            Statement stmt = conn.createStatement();
			
			// 3
			System.out.println("Send SQL ...");
			stmt.executeUpdate(strSQL);
			stmt.close();
			
			strSQL = "select a.*,b.name from media as a left outer join publisher as b"
					+ " on a.id_publisher = b.id where a.type = 0;";
			
			
			// 2
			System.out.println("Create statement ...");
            stmt = conn.createStatement();
			
			// 3
			System.out.println("Send SQL ...");
			ResultSet rs = stmt.executeQuery(strSQL);
			
			//4
			while(rs.next()) {
				System.out.print("Title : " + rs.getString("title"));
				System.out.print(" - " + rs.getFloat("price") + " €");
				System.out.println(" - " + rs.getString("name"));
			}
			
			//5
			stmt.close();
			rs.close();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    
	}
	
	/**********************************/
	/* Fin du main, début des méthodes*/
	/**********************************/
	
	public static int add(int a, int b) {
		return(a+b);
	}
	
	public static void display(int[] tab) {
		for(int i = 0; i < tab.length ; i++) {
			System.out.print(tab[i]+" ");
		}
		System.out.print("\n");
			
	}
	
	public static int tabSum(int[] tab) {
		int sum = 0;
		for(int i = 0; i < tab.length ; i++) {
			sum = sum+tab[i];
		}
		return(sum);
	}
	
	public static int maximum(int[] tab) {
		int max = tab[0];
		for(int i = 1; i < tab.length ; i++) {
			if(tab[i] > max)
				max = tab[i];
		}
		return max;
	}
	
	public static double average(int[] tab) {
		double moy = 0;
		moy = ((double)tabSum(tab))/((double)tab.length);
		return moy;
	}
	
	public static int[] randomTab(int index) {
		int[] randomTab = new int[index];

		Random randomGenerator = new Random();
	    for (int i = 0; i < index; i++){
	      randomTab[i] = randomGenerator.nextInt(100);
	    }
	    return randomTab;
	}
	
	public static int[] put(int[] tab, int index, int value) {
		tab[index] = value;
		return tab;
	}
	
	public static int[] permut(int[] tab, int index1, int index2) {
		int memo;
		memo = tab[index1];
		tab[index1] = tab[index2];
		tab[index2] = memo;
		return tab;
	}
	
	public static int[] permut2(int[] tab, int index) {
		int memo;
		memo = tab[index];
		tab[index] = tab[index-1];
		tab[index-1] = memo;
		return tab;
	}
	
	public static int[] insert(int[] tab, int index, int value) {
		for(int i=tab.length-2 ; i>=index ; i--) {
			tab[i+1] = tab[i];
		}
		tab[index] = value;
		return tab;
	}
	
	public static int[] remove(int[] tab, int index) {
		for(int i=index ; i<tab.length-1 ; i++) {
			tab[i] = tab[i+1];
		}
		return tab;
	}

}
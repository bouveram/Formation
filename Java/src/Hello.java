import java.util.Random;

public class Hello {

	public static void main(String[] args) {
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
	    premierLivre.title = "Java";
	    deuxiemeLivre.title = premierLivre.title;
	    System.out.println(premierLivre.title);
	    //deuxiemeLivre = premierLivre;
	    
	    if(premierLivre == deuxiemeLivre)
	    	System.out.println("c'est les mêmes livres");
	    else
	    	System.out.println("c'est pas les mêmes livres");
	    
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
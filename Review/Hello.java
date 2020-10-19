public class Hello {
	// Campos
	static final int VALUE = 10;
	// Métodos
	static int inc(int a) { return a+1; }
	static int inc() { return 1; }
	
	
	public static void main(String[] arg) {
		  System.out.println(Hello.inc());
		  System.out.println(inc(10));
		  System.out.println(inc(Hello.VALUE+2));
		  
		  int[] a = new int[10];
		  System.out.println(a.length);
		  a[3] = 5;
		  //a[10] = 7;
		  //a.length = 11;
		  //System.out.println(a.length);		  
	}
}
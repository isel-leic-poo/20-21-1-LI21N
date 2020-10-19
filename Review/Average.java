import java.util.*;
public class Average {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] Args) {
   int a,b,c;
   a = in.nextInt();
   b = in.nextInt();  
   c = in.nextInt();    
   float media = (a+b+c) / 3F;
   System.out.println("Average="+media);
  }
}
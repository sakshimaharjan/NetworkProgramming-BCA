import javax.print.DocFlavor.URL;

public class VRLEquality {
    public static void main(String[] args) {
        try{
            URL u1 = new URL("www.abc.com");
            URL u2 = new URL("www.example.com");
            if(u1.equals(u2)){
                System.out.println(u1+"is same as"+u2);
            }
            else{
                System.out.println(u1+"is not as same as"+u2);
            } 
        }catch(Exception e){
            System.out.println(e);;
        }
    }
}

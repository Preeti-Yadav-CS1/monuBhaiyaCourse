// import java.util.*;
public class WrapperClasstut{
    public static void main(String[] args) {
        int a=10;
        Integer a1=10;
        System.out.println(a);
        System.out.println(a1);
        a1=a;//autoboxing
        int x=156;
        Integer y=156;
        x=y;//unboxing
        System.out.println(x==y);

        Integer c=16;
        Integer c1=16;
        Integer d= 167;
        Integer d1= 167;
        //float and double dont have any cache memory 
        //Integer cache memory size -128 to 128

        System.out.println(c==c1);
        System.out.println(d==d1);
    }
}
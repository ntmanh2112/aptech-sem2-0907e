package javaadvanced.Bai1;
import java.util.*;
import java.lang.Math;
public class TamGiac {
    public static void main(String[] args) {
        int x1,y1,x2,y2,x3,y3;
        double a=0 ,b=0 ,c=0 ,p=0,S=0 , temp=0;
        Scanner input = new Scanner(System.in);
        System.out.println("CHUONG TRINH TIM KHOANG CACH, CHU VI, DIEN TICH TAM GIAC");

        System.out.println("Nhap toa do cua A");
        x1 = input.nextInt();
        y1 = input.nextInt();

        System.out.println("Nhap toa do cua B");
        x2 = input.nextInt();
        y2 = input.nextInt();

        System.out.println("Nhap toa do cua C");
        x3 = input.nextInt();
        y3 = input.nextInt();

        temp = ((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2));
        c = Math.sqrt(temp);
        temp = ((x1-x3)*(x1-x3))+((y1-y3)*(y1-y3));
        b = Math.sqrt(temp);
        temp = ((x2-x3)*(x2-x3))+((y2-y3)*(y2-y3));
        a = Math.sqrt(temp);

        System.out.println("Khoang cach AB la :" + c);
        System.out.println("Khoang cach AC la :" + b);
        System.out.println("Khoang cach BC la :" + a);
        
        p = (a+b+c)/2;
        System.out.println("Nua chu vi la :" + p);
        System.out.println("Chu vi cua tam giac la :" + (2*p));
        temp = p*(p-a)*(p-b)*(p-c);
        S = Math.sqrt(temp);
        System.out.println("Dien tich cua tam giac la :" + S);
    }
}

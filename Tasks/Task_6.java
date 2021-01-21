package Tasks;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

int  x= Integer.parseInt(reader.readLine());
        System.out.println((x%1000==x) ? "This is a three-digit number" : "This isn't a three-digit number");
        int z = x%10;
        System.out.println((z==7)?"Last digit is a seven" : "Last digit isn't a seven");
        System.out.println((x%2==0)? "This is an even number" : "This is an odd number");
    }
}

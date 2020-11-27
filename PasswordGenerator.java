import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordGenerator {

    public static String insertAtRandom(String str, String toInsert){
    int n = str.length();
    int r = (int)  ((n-1) * Math.random());
    return str.substring(0,r) + toInsert + str.substring(r);
    }

    public static String randomCharacter(String characters){
        int n = characters.length();
        int r = (int) (n*Math.random()); //math random returns real number between 0.0 and 1.0
        return characters.substring(r, r+1);
    }

    public static String makePassword(int length){
        String password = "";

        for(int i=0;i<length;i++)
        {
            password = password + randomCharacter("ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvwxyz");
        }
        for(int i=0;i<length/3;i++) {
            String randomDigit = randomCharacter("0123456789");
            password = insertAtRandom(password, randomDigit);
            String randomSymbol = randomCharacter("!@#$%^&*()_+[]'/.,><~/*-+");
            password = insertAtRandom(password, randomSymbol);
        }
        return password.substring(0,length);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter password length: ");
        String passwordLength = br.readLine();
        String result = makePassword(Integer.parseInt(passwordLength));
        System.out.println(result);
    }
}




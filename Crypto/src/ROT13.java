import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ROT13  {
    public int value;

    ROT13(Character cs, Character cf) {
        if(cf - cs > 0) { this.value = cf - cs; }
        else if(cf - cs < 0) { this.value = -(cf - cs); }
    }

    ROT13() {
        this.value = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'm') { currentChar += value; }
            else if (currentChar >= 'n' && currentChar <= 'z') { currentChar -= value; }
            else if (currentChar >= 'A' && currentChar <= 'M') { currentChar += value; }
            else if (currentChar >= 'N' && currentChar <= 'Z') { currentChar -= value; }
            message.append(currentChar);
        }
        return message.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        return s.substring(s.indexOf(c)) + s.substring(0, s.indexOf(c));
    }

    public String readFile() throws FileNotFoundException {
        File file = new File("/Users/xiong/Projects/SimpleCrypt/sonnet18.txt");
        Scanner scan = new Scanner(file);
        String fileContents = "";

        while (scan.hasNextLine()) {
            fileContents = fileContents.concat((scan.nextLine() + "\n"));
        }

        return fileContents;
    }

    public void writeEncryptedFile() throws IOException {
        FileWriter writer = new FileWriter("/Users/xiong/Projects/SimpleCrypt/sonnet18-ROT13Encrypt.txt");
        writer.write(encrypt(readFile()));
        writer.close();
    }

    public String readEncryptedFile() throws FileNotFoundException {
        File file = new File("/Users/xiong/Projects/SimpleCrypt/sonnet18-ROT13Encrypt.txt");
        Scanner scan = new Scanner(file);
        String fileContents = "";

        while (scan.hasNextLine()) {
            fileContents = fileContents.concat((scan.nextLine() + "\n"));
        }

        return fileContents;
    }

    public void writeDecryptedFile() throws IOException {
        FileWriter writer = new FileWriter("/Users/xiong/Projects/SimpleCrypt/sonnet18-ROT13Decrypt.txt");
        writer.write(decrypt(readEncryptedFile()));
        writer.close();
    }

}

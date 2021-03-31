import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCrypt extends ROT13{

    public CaesarCrypt() {
        this.value = 3;
    }

    @Override
    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'd' && currentChar <= 'z') { currentChar -= value; }
            else if (currentChar >= 'a' && currentChar <= 'c') { currentChar += (value + 20); }
            else if (currentChar >= 'D' && currentChar <= 'Z') { currentChar -= value; }
            else if (currentChar >= 'A' && currentChar <= 'C') { currentChar += (value + 20); }
            message.append(currentChar);
        }
        return message.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'w') { currentChar += value; }
            else if (currentChar >= 'x' && currentChar <= 'z') { currentChar -= (value + 20); }
            else if (currentChar >= 'A' && currentChar <= 'W') { currentChar += value; }
            else if (currentChar >= 'X' && currentChar <= 'Z') { currentChar -= (value + 20); }
            message.append(currentChar);
        }
        return message.toString();
    }

    @Override
    public void writeEncryptedFile() throws IOException {
        FileWriter writer = new FileWriter("/Users/xiong/Projects/SimpleCrypt/sonnet18-CaesarEncrypt.txt");
        writer.write(encrypt(readFile()));
        writer.close();
    }

    @Override
    public String readEncryptedFile() throws FileNotFoundException {
        File file = new File("/Users/xiong/Projects/SimpleCrypt/sonnet18-CaesarEncrypt.txt");
        Scanner scan = new Scanner(file);
        String fileContents = "";

        while (scan.hasNextLine()) {
            fileContents = fileContents.concat((scan.nextLine() + "\n"));
        }

        return fileContents;
    }

    @Override
    public void writeDecryptedFile() throws IOException {
        FileWriter writer = new FileWriter("/Users/xiong/Projects/SimpleCrypt/sonnet18-CaesarDecrypt.txt");
        writer.write(decrypt(readEncryptedFile()));
        writer.close();
    }
}

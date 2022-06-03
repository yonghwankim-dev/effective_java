package role9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class CloseableResource implements AutoCloseable {
    private BufferedReader reader;

    public CloseableResource(String fileName) {
        InputStream input = CloseableResource.class.getResourceAsStream(fileName);
        reader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        String firstLine = reader.readLine();
        return firstLine;
    }

    @Override
    public void close() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the close method");
        } catch (IOException e) {
            // handle exception
        }
    }
}
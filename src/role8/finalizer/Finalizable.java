package role8.finalizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Finalizable {
    private BufferedReader reader;

    // »ý¼ºÀÚ
    public Finalizable() {
    	
        InputStream input = Finalizable.class.getResourceAsStream("file.txt");
        this.reader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        String firstLine = reader.readLine();
        return firstLine;
    }

	@Override
	protected void finalize(){
		try {
			reader.close();
			System.out.println("Closed BufferedReader in the finalizer");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    // other class members
}

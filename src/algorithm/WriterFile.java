package algorithm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterFile {

    private String path;

    public WriterFile(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void writeLines(String[] strings){
        FileWriter arq = null;
        try {
            arq = new FileWriter(this.path);
            PrintWriter gravarArq = new PrintWriter(arq);

            for (int k = 0; k < strings.length; k++) {
                gravarArq.printf("%s\n", strings[k]);
            }

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

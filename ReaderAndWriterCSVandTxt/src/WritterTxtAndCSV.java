import module.ModuleWritter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritterTxtAndCSV implements ModuleWritter {
    @Override
    public void writterTxtAndCsv(String path, List<String> data) {
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(path)));
            bwr.write("REKAP NILAI\n\n");

            for (int i = 0; i < data.size(); i++) bwr.write(data.get(i) + "\n");

            bwr.newLine();
            bwr.flush();
            bwr.close();
            System.out.println("succesfully written to a file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

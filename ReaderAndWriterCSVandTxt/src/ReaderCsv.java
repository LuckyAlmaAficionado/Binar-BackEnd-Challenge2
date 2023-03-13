import module.ModuleRead;
import solving.Mean;
import solving.Median;
import solving.Modus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReaderCsv implements ModuleRead {
    @Override
    public List<String> readerCsv(String path, int opsi) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        /*
            Deklarasi List
            berguna untuk menampung data yang diberikan oleh setiap fungsi
         */
        List<String> paketNilai = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> tempMod = new ArrayList<>();
        List<Integer> tempMed = new ArrayList<>();
        float value = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            String[] tempArr;
            int lenghtOfNumbers = 0;

            while ((line = br.readLine()) != null) {
                temp.clear();
                tempArr = line.split(";");
                for (int i = 0; i < tempArr.length; i++) {
                    if (i >= 1) {
                        lenghtOfNumbers++;
                        value += Integer.valueOf(tempArr[i]);
                        tempMed.add(Integer.valueOf(tempArr[i]));
                        temp.add(Integer.valueOf(tempArr[i]));
                    } else paketNilai.add(tempArr[i]);
                }

                switch (opsi) {
                    case 1:
                        paketNilai.add("Modus   : " + Modus.getModus(temp) + "\n");
                        tempMod.add(Modus.getModus(temp));
                        break;
                    case 2:
                        paketNilai.add("Mean    : " + Mean.getMean(temp));
                        paketNilai.add("Median  : " + Median.getMedian(temp) + "\n");
                        break;
                    case 3:
                        paketNilai.add("Median  : " + Median.getMedian(temp));
                        paketNilai.add("Mean    : " + Mean.getMean(temp));
                        paketNilai.add("Modus   : " + Modus.getModus(temp) + "\n");
                        tempMod.add(Modus.getModus(temp));
                        break;
                    default:
                        break;

                }
            }

            if (opsi == 1) {
                paketNilai.add("Berikut Hasil Pengolahan Nilai: ");
                paketNilai.add("Berikut hasil sebaran data nilai");
                paketNilai.add("Modus   : " + Modus.getModus(tempMod));
            } else if(opsi == 2) {
                paketNilai.add("Berikut Hasil Pengolahan Nilai: ");
                paketNilai.add("Berikut hasil sebaran data nilai");
                paketNilai.add("Mean    : " + decimalFormat.format(value / lenghtOfNumbers));
                paketNilai.add("Median  : " + Median.getMedian(tempMed));
            } else if (opsi == 3) {
                paketNilai.add("Berikut Hasil Pengolahan Nilai: ");
                paketNilai.add("Berikut hasil sebaran data nilai");
                paketNilai.add("Modus   : " + Modus.getModus(tempMod));
                paketNilai.add("Mean    : " + decimalFormat.format(value / lenghtOfNumbers));
                paketNilai.add("Median  : " + Median.getMedian(tempMed));
            }

            /*

            per kelas / semua
            modus
            mean
            median

             */

            br.close();
            return paketNilai;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

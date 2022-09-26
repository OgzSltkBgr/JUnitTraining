package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class M04 {
    @Test
    public void readExcel() throws IOException {


        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // İngilizce baskentler sutununu yazdiralim

        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        String satirdakiData="";

        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=M03.banaDataGetir(i,1);
           // System.out.println(satirdakiData);
        }
        List<String> baskentler=new ArrayList<>();
        baskentler.add(satirdakiData);
        System.out.println(baskentler.size());
    }
}

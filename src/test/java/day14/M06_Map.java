package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class M06_Map {
    @Test
    public void readExcel() throws IOException {
        // excel dosyasındaki tum verileri classimiza alip
        // bir Java objesine store edelim
        // boylece her seferinde excel eulaşığ satir sutun vs ugrasmayalım

        Map<String,String> ulkelerMap = new HashMap<>();
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            //key i. satirdaki 0 indexdeki data olacak
            String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            // value ise i. satirdaki 1,2 ve 3. indexdeki datalarin birlesimi olacak
            String value =workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
                    ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);

        // Listede Ghana oldugunu test edelim

        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));




    }
}

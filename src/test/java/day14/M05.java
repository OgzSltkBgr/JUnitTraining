package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class M05 {
    @Test
    public void readExcel() throws IOException {


        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // sayfa 2 ye gidip satir sayısının 24 kullanılan satır sayısının 12 oldugunu test edin

        int sonSatirIndex= workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirSayisi=24;

        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);

        int kullanilanSatirSayisi= workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi=12;

        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);



    }
}

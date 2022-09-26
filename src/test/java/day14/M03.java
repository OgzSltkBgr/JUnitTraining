package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class M03 {
    @Test
    public void readExcel() throws IOException {
        //Belirtilen satırNo ve sutunNo değerlerini parametre olarak alıp o cell'deki datayı konsola yazdıralım
        //Sonucun konsolda yazanla aynı olduğunu doğrulayın

        int satirNo=4;
        int sutunNo=4;

        // donen String'in Cezayir oldugunu test edin
        String expectedData="Cezayir";

        String actualData=banaDataGetir(satirNo-1,sutunNo-1); // Cunku excel index ile çalışır

        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return istenenData;
    }
}

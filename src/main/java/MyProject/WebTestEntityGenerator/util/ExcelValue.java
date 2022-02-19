package MyProject.WebTestEntityGenerator.util;

import MyProject.WebTestEntityGenerator.rest.dto.AsmeMaterialDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelValue {
    public List<AsmeMaterialDTO> getValues() throws IOException {
        List<AsmeMaterialDTO> resList = new ArrayList<>();
        try (Workbook excel = new XSSFWorkbook(
                new FileInputStream(new File("/home/yoba/Рабочий стол/asme/DATABASE.xlsx")))) {
            Sheet sheet = excel.getSheet("asme_yield_strength"); // 1482col 25row yield ! 1398col 20row strength
            for (int i = 1; i < 1482; i++) {
                Row row = sheet.getRow(i);

                AsmeMaterialDTO material = new AsmeMaterialDTO();
                material.setGrade(row.getCell(3).toString());
                material.setId(Long.valueOf(row.getCell(0).toString().replace(".0","")));
                material.setSpec(row.getCell(2).toString());
                material.setNominalComposition(row.getCell(1).toString());
                material.setUns(row.getCell(4).toString());

                for (int j = 0; j < 4; j++) {
                    try {/*
                        if (j == 0) {
                            String lul = row.getCell(0).toString().replace(".0", "");
                            list.add(lul);
                        } else if (j == 1 || j == 2 || j == 3 || j == 4) {
                            // String lul1 = "'" + row.getCell(j).toString().replace(".0", "") + "'";
                            //list.add(lul1);
                        } else {
                            list.add(row.getCell(j).toString());
                        }
                        */

                    } catch (NullPointerException e) {
                        System.out.println(i + "  " + j);
                    }
                }
                resList.add(material);
            }

        }
        return resList;
    }
}

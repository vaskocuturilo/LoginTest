package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * The type Read excel.
 */
public final class DataProviders {

    /**
     * Default constructor DataProviders.
     */
    private DataProviders() {
    }

    /**
     * Method getCellData.
     *
     * @param path  the path
     * @param sheet the sheet
     * @return the string [ ] [ ]
     * @throws InvalidFormatException the invalid format exception
     * @throws IOException            the io exception
     */
    public static String[][] getCellData(final String path, final String sheet) throws InvalidFormatException, IOException {
        FileInputStream stream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(stream);
        Sheet workbookSheet = workbook.getSheet(sheet);

        int rowNum = workbookSheet.getLastRowNum();
        int cellNum = workbookSheet.getRow(0).getLastCellNum();

        String data[][] = new String[rowNum][cellNum];

        for (int i = 1; i <= rowNum; i++) {
            Row r = workbookSheet.getRow(i);
            for (int j = 0; j < cellNum; j++) {
                Cell cell = r.getCell(j);
                try {
                    if (cell.getCellType() == cell.CELL_TYPE_STRING) {
                        data[i - 1][j] = cell.getStringCellValue();
                    } else {

                        data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}

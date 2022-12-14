package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Course;
import com.crackware.erasmus.data.model.School;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
/**
 * Helper class which handles Excel operations
 */
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "Sheet1";

    // Function which checks whether an input file is in Excel format or not
    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    // Function which gets input contents input file
    public static List<Course> excelToCourses(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Course> courses = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Course course = new Course();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 1:{
                            String value = "";
                            if (currentCell.getCellType() == CellType.NUMERIC)
                                value = String.valueOf(currentCell.getNumericCellValue());
                            if (currentCell.getCellType() == CellType.STRING)
                                value = currentCell.getStringCellValue();
                            if (!value.equals("")
                                    && !value.equals("       Host University's Name"))
                            {
                                course.setHostUniversityName(value);
                            }
                            break;
                        }
                        case 2:{
                            String value = "";
                            if (currentCell.getCellType() == CellType.NUMERIC)
                                value = String.valueOf(currentCell.getNumericCellValue());
                            if (currentCell.getCellType() == CellType.STRING)
                                value = currentCell.getStringCellValue();
                            if (!value.equals("")
                                && !value.equals(" Host University's Department/Program"))
                            {
                                course.setDepartment(value);
                            }
                            break;
                        }
                        case 3:{
                            String value = "";
                            if (currentCell.getCellType() == CellType.NUMERIC)
                                value = String.valueOf(currentCell.getNumericCellValue());
                            if (currentCell.getCellType() == CellType.STRING)
                                value = currentCell.getStringCellValue();
                            if (!value.equals("")
                                    && !value.equals("Host University's Course Code"))
                            {
                                course.setCourseCode(value);
                            }
                            break;
                        }
                        case 4:{
                            String value = "";
                            if (currentCell.getCellType() == CellType.NUMERIC)
                                value = String.valueOf(currentCell.getNumericCellValue());
                            if (currentCell.getCellType() == CellType.STRING)
                                value = currentCell.getStringCellValue();
                            if (!value.equals("")
                                    && !value.equals("Host University's Course name"))
                            {
                               course.setCourseName(value);
                            }
                            break;
                        }
                        default:
                            break;
                    }

                    cellIdx++;
                }

                if (course.getCourseCode() != null)
                    courses.add(course);
            }

            workbook.close();

            return courses;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
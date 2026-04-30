package utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataAdapter{
    private static String testCaseName;
    private static String username;
    private static String password;

    public static String[] readDataFromExcelFile() throws IOException {
        String[] tokens = new String[3];
        FileInputStream file = new FileInputStream(new File("src/test/resources/data.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        testCaseName = sheet.getRow(1).getCell(0).getStringCellValue();
        username = sheet.getRow(1).getCell(1).getStringCellValue();
        password = sheet.getRow(1).getCell(2).getStringCellValue();

        tokens[0] = testCaseName;
        tokens[1] = username;
        tokens[2] = password;
        return tokens;
    }


    public static String[] readDataFromTextFile() throws FileNotFoundException {
        FileInputStream file = new FileInputStream(new File("src/test/resources/data.txt"));
        Scanner fileScanner = new Scanner(file);
        String[] tokens = new String[3];
        try {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //line.split(":|,");
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("[:,]"); // Split in a colon or in a comma.

                testCaseName = lineScanner.next();
                tokens[0] = testCaseName;
                username = lineScanner.next();
                tokens[1] = username;
                password = lineScanner.next();
                tokens[2] = password;
                System.out.println("Test case name: "+ testCaseName);
                System.out.println("Username: "+username);
                System.out.println("Password: "+password);
                lineScanner.close();
            }
        }
        finally {
            fileScanner.close();
        }
        return tokens;
    }

    public static String[] readDataFromJsonFile(){
        String[] tokens = new String[3];
        try{
            Path filePath = Paths.get("src/test/resources/data.json");
            String json = Files.readString(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            testCaseName = rootNode.path("tests").get(0).path("testCaseName").asText();
            username = rootNode.path("tests").get(0).path("username").asText();
            password = rootNode.path("tests").get(0).path("password").asText();

            tokens[0] = testCaseName;
            tokens[1] = username;
            tokens[2] = password;
            return tokens;



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package Util;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class Utility {


    public static List<Integer> generateUniqueRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

        public static Integer removeRandomInteger(List<Integer> list) {
            // Check if the list is empty
            if (list.isEmpty()) {
                throw new IllegalArgumentException("The list is empty.");
            }

            // Generate a random index within the bounds of the list
            Random random = new Random();
            int index = random.nextInt(list.size());

            // Remove the element at the random index
            return list.remove(index);
        }


    //method for choose random  number regarding number that sent from TC
public static void main(String[] args) {
    List<Integer> uniqeRandomNumbers = generateUniqueRandomNumbers(2);
    for (int number : uniqeRandomNumbers) {
        System.out.println(number);
    }
    System.out.println(uniqeRandomNumbers);
//     }
    //System.out.println(parsePriceFromString("$9.99"));
}
    // parse float values
    public static float parsePriceFromString(String priceString) {
        if (priceString == null || priceString.isEmpty()) {
            throw new IllegalArgumentException("Price string cannot be null or empty");
        }

        // Remove leading and trailing whitespaces (optional)
        priceString = priceString.trim();

        // Check if the string starts with a dollar sign ($)
        if (!priceString.startsWith("$")) {
            throw new IllegalArgumentException("Price string must start with a dollar sign ($)");
        }

        // Extract the number part (everything after the dollar sign)
        String numberString = priceString.substring(1);

        // Parse the number string to a float
        try {
            return Float.parseFloat(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format. Please provide a valid number after the dollar sign ($)", e);
        }
    }
    // read from json
    public static String getSingleJsonData(String jsonFilePath,String jsonField) throws IOException, ParseException, IOException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }
    // read from excel
    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/test_data/data.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }
//read from json multiple items
public static String[] readJson(String jsonFilePath,String jsonFieldArray,String field) throws IOException, ParseException {

    JSONParser jsonParser = new JSONParser();

    FileReader fileReader = new FileReader(jsonFilePath);
    Object obj = jsonParser.parse(fileReader);

    JSONObject jsonObject = (JSONObject) obj;
    JSONArray array = (JSONArray) jsonObject.get(jsonFieldArray);

    String[] arr = new String[array.size()];
    for (int i = 0; i < array.size(); i++) {
        JSONObject users = (JSONObject) array.get(i);
        String fieldData = (String) users.get(field);

        arr[i] = fieldData;
    }
    return arr;
}

//method for choose random  number regarding number that sent from TC
//    public static void main(String[] args) {
//        List<Integer> uniqeRandomNumbers=generateUniqueRandomNumbers(6);
//        for (int number:uniqeRandomNumbers){
//            System.out.println(number); }
//       // System.out.println(uniqeRandomNumbers);
//
//        }
        //System.out.println(parsePriceFromString("$9.99"));
    }

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GK_Quiz {
    public static void main(String[] args) throws IOException, ParseException {
        writeList();
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i <= 4; i++) {
            Random r = new Random();
            int low = 1;
            int high = 8;
            int result = r.nextInt(high - low) + low;
            printQuestion(result);
            String ans = sc.next();
            int point = crossCheck(result, ans);
            sum += point;
        }
        System.out.println("Your final point is: "+sum);
    }

    static void writeList() throws IOException, ParseException {
        String filename = "./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray = (JSONArray) obj;
        FileWriter file = new FileWriter(filename);
        jsonObject1.put("id", 1);
        jsonObject1.put("Question", "What is the capital city of Canada?");
        jsonObject1.put("Answer", "Toronto");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("id", 2);
        jsonObject2.put("Question", "What is the capital city of India?");
        jsonObject2.put("Answer", "Delhi");
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("id", 3);
        jsonObject3.put("Question", "What is the currency of England?");
        jsonObject3.put("Answer", "Euro");
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("id", 4);
        jsonObject4.put("Question", "What is the tallest mountain?");
        jsonObject4.put("Answer", "Everest");
        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("id", 5);
        jsonObject5.put("Question", "What is the biggest desert?");
        jsonObject5.put("Answer", "Sahara");
        JSONObject jsonObject6 = new JSONObject();
        jsonObject6.put("id", 6);
        jsonObject6.put("Question", "What is the biggest forrest?");
        jsonObject6.put("Answer", "Amazon");
        JSONObject jsonObject7 = new JSONObject();
        jsonObject7.put("id", 7);
        jsonObject7.put("Question", "Which team won the most amount of football world cup?");
        jsonObject7.put("Answer", "Brazil");
        JSONObject jsonObject8 = new JSONObject();
        jsonObject8.put("id", 8);
        jsonObject8.put("Question", "On which year the freedom war took place in Bangladesh");
        jsonObject8.put("Answer", "1971");
        JSONObject jsonObject9 = new JSONObject();
        jsonObject9.put("id", 9);
        jsonObject9.put("Question", "What is the biggest island in the world?");
        jsonObject9.put("Answer", "Greenland");
        JSONObject jsonObject10 = new JSONObject();
        jsonObject10.put("id", 10);
        jsonObject10.put("Question", "How many continents is there in the world");
        jsonObject10.put("Answer", "7");
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);
        jsonArray.add(jsonObject4);
        jsonArray.add(jsonObject5);
        jsonArray.add(jsonObject6);
        jsonArray.add(jsonObject7);
        jsonArray.add(jsonObject8);
        jsonArray.add(jsonObject9);
        jsonArray.add(jsonObject10);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    static void printQuestion(int i) throws IOException, ParseException {
        String filename = "./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
        String q = (String) jsonObject.get("Question");
        System.out.println(q);
    }

    static int crossCheck(int i, String s) throws IOException, ParseException {
        int c = 0;
        String filename = "./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
        String q = (String) jsonObject.get("Answer");
        if (q.equals(s)) {
            System.out.println("Correct!!");
            c++;
        } else {
            System.out.println("Wrong Answer");
        }
        return c;
    }
}


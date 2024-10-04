import com.mitchtalmadge.asciidata.graph.ASCIIGraph;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.*;
import java.text.ParseException;


public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("                         )/_");
        System.out.println("               _.--..---\"-,--c_");
        System.out.println("          \\L..'           ._O__)_");
        System.out.println("  ,-.     _.+  _  \\..--( /             ");
        System.out.println("    `\\.-''__.-' \\ (     \\_      ");
        System.out.println("      `'''       `\\__   /\\");
        System.out.println("                  ')");
        System.out.println("===================================");
        System.out.println("         WELCOME TO MY MENU       ");
        System.out.println("===================================");
        System.out.println("          [1] Recordbook          ");
        System.out.println("          [2] Calculator          ");
        System.out.println("          [3] Monkeytype          ");
        System.out.println("===================================");
        System.out.print("       Please select an option:  ");


        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("exit")) {
            running = false;
        }

        else if (answer.equalsIgnoreCase("recordbook")) {
            timesleep();

            recordbook();
        } else if (answer.equalsIgnoreCase("Monkeytype")) {

            MonkChart();


        } else if (answer.equalsIgnoreCase("calculator")) {
            calculator();

            scanner.close();
        }
        else {
            System.out.println("Invalid option try again");
            main(args);
        }

    }




    public static void MonkChart() {
        String ChartData = "results.csv"; // Path to your CSV file
        List<Double> yValues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ChartData))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip the header line
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                // Split the line by comma
                String[] data = line.split(",");
                double yValue;

                try {
                    yValue = Double.parseDouble(data[1]);
                    yValues.add(yValue);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Number: " + data[1]);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        double[] yArray = new double[yValues.size()];
        for (int i = 0; i < yValues.size(); i++) {
            yArray[i] = yValues.get(i);
        }

        String chart = ASCIIGraph
                .fromSeries(yArray)
                .withTickFormat(new DecimalFormat("##0.00000"))
                .withNumRows(8)
                .plot();
        System.out.println("-----------------------------------------");
        System.out.println(chart);
        System.out.println("-----------------------------------------");
    }

    public static void timesleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static  void calculator() {
        boolean running = true;
        while (running) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Gib die erste Zahl ein: ");
        double num1 = scanner.nextDouble();


        System.out.print("Gib die zweite Zahl ein: ");
        double num2 = scanner.nextDouble();


        System.out.print("Wähle einen Operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = 0;


        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Fehler: Division durch Null ist nicht erlaubt.");
                    return;
                }
                break;
            default:
                System.out.println("Ungültiger Operator!");
                return;
        }


        updateDisplay(result);
    }}


    public static void updateDisplay(double value) {

        System.out.println(" _____________________ ");
        System.out.println("|  _________________  |");
        System.out.printf("| | JO         %5.2f | |\n", value);
        System.out.println("| |_________________| |");
        System.out.println("|  ___ ___ ___   ___  |");
        System.out.println("| | 7 | 8 | 9 | | + | |");
        System.out.println("| |___|___|___| |___| |");
        System.out.println("| | 4 | 5 | 6 | | - | |");
        System.out.println("| |___|___|___| |___| |");
        System.out.println("| | 1 | 2 | 3 | | x | |");
        System.out.println("| |___|___|___| |___| |");
        System.out.println("| | . | 0 | = | | / | |");
        System.out.println("| |___|___|___| |___| |");
        System.out.println("|_____________________|");
    }


    private static void recordbook() {
        final String INPUT_CSV_FILE = "day_answer.csv";
        String csvFilePath = "day_answer.csv";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        List<String[]> csvData = new ArrayList<>();

        while (running) {
            System.out.println("               (( _______");
            System.out.println("     _______     /\\O    O\\");
            System.out.println("    /O     /\\   /  \\      \\");
            System.out.println("   /   O  /O \\ / O  \\O____O\\ ))");
            System.out.println("((/_____O/    \\\\    /O     /");
            System.out.println("  \\O    O\\    / \\  /   O  /");
            System.out.println("   \\O    O\\ O/   \\/_____O/");
            System.out.println("    \\O____O\\/ ))             ))");
            System.out.println("  ((");
            System.out.println("===================================");
            System.out.println("         WELCOME TO MY MENU        ");
            System.out.println("===================================");
            System.out.println("          [1] Create               ");
            System.out.println("          [2] Edit                 ");
            System.out.println("          [3] Search               ");
            System.out.println("          [4] List                 ");
            System.out.println("          [5] Exit                 ");
            System.out.println("===================================");
            System.out.print("     Please select an option:        ");

            while (running) {
                String choice = scanner.nextLine();



                switch (choice.toLowerCase()) {

                    case "1":
                    case "hassann":
                        // Create operation
                        System.out.print("Enter Report Date (yyyy-MM-dd): ");
                        String date = scanner.nextLine();
                        System.out.print("Tell about your day: ");
                        String answer = scanner.nextLine();

                        try (FileWriter writer = new FileWriter(csvFilePath, true)) {
                            writer.append(date).append(",").append(answer).append("\n");
                            System.out.println("The entry has been saved in the CSV file.");
                        } catch (IOException e) {
                            System.out.println("Error saving to the CSV file.");
                            e.printStackTrace();
                        }
                        break;

                    case "2":
                    case "edit":
                        // Edit operation
                        System.out.print("Which date would you like to edit? (yyyy-MM-dd): ");
                        String editDate = scanner.nextLine();
                        csvData.clear(); // Clear the list for fresh data loading
                        boolean isRowFound = false;

                        // Read CSV file
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] rowData = line.split(",");
                                csvData.add(rowData); // Add rows to csvData
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Search for the row to edit
                        for (String[] row : csvData) {
                            if (row[0].equals(editDate)) { // Date column check
                                System.out.println("Row found: " + String.join(", ", row));
                                isRowFound = true;

                                // Ask which field to edit
                                System.out.println("Which field would you like to edit?");
                                System.out.println("1. Date\n2. Answer");
                                String fieldChoice = scanner.nextLine();

                                if ("1".equals(fieldChoice)) {
                                    System.out.print("Enter new date (yyyy-MM-dd): ");
                                    row[0] = scanner.nextLine();
                                } else if ("2".equals(fieldChoice)) {
                                    System.out.print("Enter new answer: ");
                                    row[1] = scanner.nextLine();
                                } else {
                                    System.out.println("Invalid option. No changes made.");
                                }

                                break;
                            }
                        }

                        if (!isRowFound) {
                            System.out.println("No row found for the date: " + editDate);
                        } else {
                            // Write the updated CSV back
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
                                for (String[] row : csvData) {
                                    bw.write(String.join(",", row));
                                    bw.newLine();
                                }
                                System.out.println("CSV file updated successfully.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;

                    case "3":
                    case "search":
                        // Search operation
                        System.out.print("Enter the value you want to search: ");
                        String searchValue = scanner.nextLine().trim();
                        boolean found = false;

                        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] values = line.split(",");
                                if (Arrays.stream(values).anyMatch(v -> v.contains(searchValue))) {
                                    System.out.println("===================");
                                    System.out.println("Found: " + line);
                                    found = true;
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Error reading the CSV file.");
                            e.printStackTrace();
                        }

                        if (!found) {
                            System.out.println("No matching record found.");
                        }
                        break;

                    case "4":
                    case "list":
                        // List operation
                        csvData.clear(); // Clear previous data
                        System.out.println("Would you like to sort the data by date? (type 'sorted' or 'unsorted'):");
                        String sortOption = scanner.nextLine();

                        // Read CSV
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                csvData.add(line.split(","));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Sort based on user input
                        if ("sorted".equalsIgnoreCase(sortOption)) {
                            csvData.sort((row1, row2) -> {
                                try {
                                    Date date1 = sdf.parse(row1[0]);
                                    Date date2 = sdf.parse(row2[0]);
                                    return date1.compareTo(date2);
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                            System.out.println("Data sorted by date:");
                        } else {
                            System.out.println("Displaying data without sorting:");
                        }

                        // Print CSV data
                        for (String[] row : csvData) {
                            System.out.println(String.join(", ", row));
                        }
                        break;



                    case "5":
                    case "exit":

                        timesleep();
                        running = false;

                        System.out.println("                             ");
                        System.out.println("                       \"\"   ,d     ");
                        System.out.println("                            88     ");
                        System.out.println(" ,adPPYba, 8b,     ,d8 88 MM88MMM  ");
                        System.out.println("a8P_____88  `Y8, ,8P'  88   88     ");
                        System.out.println("8PP\"\"\"\"\"\"\"    )888(    88   88     ");
                        System.out.println("\"8b,   ,aa  ,d8\" \"8b,  88   88,    ");
                        System.out.println(" `" + "Ybbd8\"' 8P'     `Y8  88   \"Y888  ");
                        System.out.println("                                         ");
                }

            }
            scanner.close();
        }
    }

}

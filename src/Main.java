import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

    private static final String CLEAR_SCREEN = "\033[H\033[2J";
    private static final String RESET_CURSOR = "\033[H";


    public static void timesleep()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=====================================");
        System.out.println("   _____   __                    __ ");
        System.out.println("  / ___/  / /_  ____ _   _____  / /_");
        System.out.println("  \\__ \\  / __/ / __ `/  / ___/ / __/");
        System.out.println(" ___/ / / /_  / /_/ /  / /    / /_  ");
        System.out.println("/____/  \\__/  \\__,_/  /_/     \\__/  ");
        System.out.println("                                   ");
        System.out.println("=====================================");
        System.out.println("= Reportbook");
        System.out.println("= Calculator");
        System.out.println("= Fast Exit");
        System.out.print("What do you want to do? ");

        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("exit")) {
            running = false;
        }

        else if (answer.equalsIgnoreCase("reportbook")) {
            timesleep();
            System.out.print(CLEAR_SCREEN);
            reportmenu();
        }

        else if (answer.equalsIgnoreCase("calculator")) {
            //calculator();

            scanner.close();
        }

    }

    private static void reportmenu() {
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
            System.out.println("========================================================");
            System.out.println("                        THE MENU                        ");
            System.out.println("========================================================");
            System.out.println("= Create              ");
            System.out.println("= Edit                ");
            System.out.println("= Exit                ");
            System.out.println("= List                ");
            System.out.println("= Search              ");
            System.out.println("=====================");
            System.out.print("What is your Choice: ");

            while (running) {
                String choice = scanner.nextLine();



                switch (choice.toLowerCase()) {

                    case "1":
                    case "create":
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

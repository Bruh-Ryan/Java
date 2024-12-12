package com.example.hospital;

import java.util.Scanner;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Accessing the database
        MongoDatabase database = mongoClient.getDatabase("HospitalDATA");
        MongoCollection<Document> collection = database.getCollection("patients");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter what you need: ");
            System.out.println("1. See Client details");
            System.out.println("2. Add new client");
            System.out.println("3. Update client data");
            System.out.println("4. Delete client data");
            System.out.println("5. Exit");
			System.out.println("0. To see all dbms");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
//-----------------

 if(choice==0)
          {
            System.out.print("ALL THE DATA ON PEOPLE ARE");
			
			

            FindIterable<Document> result = collection.find();
            
            for (Document doc : result)
            System.out.println(doc.toJson());

          }

//-------------------
            if (choice == 1) {
                // reading here operation
                System.out.print("Enter Client ID: ");
                String clientId = scanner.nextLine();
                Document filter = new Document("client_id", clientId);
                Document resultName = collection.find(filter).first();

                if (resultName != null) {
                    String name = resultName.getString("name");
                    int age = resultName.getInteger("age");
                    String gender = resultName.getString("gender");
                    String admissionDate = resultName.getString("admission_date");
                    String diagnosis = resultName.getString("diagnosis");

                    String formattedOutput = String.format("Client ID: %s, Name: %s, Age: %d, Gender: %s, Admission Date: %s, Diagnosis: %s",
                        clientId, name, age, gender, admissionDate, diagnosis);

                    System.out.println(formattedOutput);
                } else {
                    System.out.println("No document found with the specified filter.");
                }
            } 
			
			
			else if (choice == 2) {
                // Createinggg operation
                System.out.print("Enter Client ID: ");
                String clientId = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter Admission Date: ");
                String admissionDate = scanner.nextLine();
                System.out.print("Enter Diagnosis: ");
                String diagnosis = scanner.nextLine();

                Document newClient = new Document("client_id", clientId)
                    .append("name", name)
                    .append("age", age)
                    .append("gender", gender)
                    .append("admission_date", admissionDate)
                    .append("diagnosis", diagnosis);

                collection.insertOne(newClient);
                System.out.println("Client added successfully.");
            } 
			
			else if (choice == 3) {
                // Update operation in this part
                System.out.print("Enter Client ID to update: ");
                String clientId = scanner.nextLine();
                Document filter = new Document("client_id", clientId);

                System.out.print("Enter new Name (leave blank to keep unchanged): ");
                String newName = scanner.nextLine();
                System.out.print("Enter new Age (leave blank to keep unchanged): ");
                String ageInput = scanner.nextLine();
                System.out.print("Enter new Gender (leave blank to keep unchanged): ");
                String newGender = scanner.nextLine();
                System.out.print("Enter new Admission Date (leave blank to keep unchanged): ");
                String newAdmissionDate = scanner.nextLine();
                System.out.print("Enter new Diagnosis (leave blank to keep unchanged): ");
                String newDiagnosis = scanner.nextLine();

                Document updateFields = new Document();
                if (!newName.isEmpty()) updateFields.append("name", newName);
                if (!ageInput.isEmpty()) updateFields.append("age", Integer.parseInt(ageInput));
                if (!newGender.isEmpty()) updateFields.append("gender", newGender);
                if (!newAdmissionDate.isEmpty()) updateFields.append("admission_date", newAdmissionDate);
                if (!newDiagnosis.isEmpty()) updateFields.append("diagnosis", newDiagnosis);

                Document updateOperation = new Document("$set", updateFields);
                collection.updateOne(filter, updateOperation);
                System.out.println("Client data updated successfully.");
            } 
			
			
			else if (choice == 4) {
                // Deleting operation
                System.out.print("Enter Client ID to delete: ");
                String clientId = scanner.nextLine();
                Document filter = new Document("client_id", clientId);
                collection.deleteOne(filter);
                System.out.println("Client data deleted successfully.");
            } else if (choice == 5) {
                
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option selected.");
            }
        }

        scanner.close();
    }
}






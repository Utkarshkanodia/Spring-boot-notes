package com.notes.jpa;

import com.notes.jpa.cardinalities.one_to_many.bidirectional.Category;
import com.notes.jpa.cardinalities.one_to_many.bidirectional.OneToManyBidirectionalClient;
import com.notes.jpa.cardinalities.one_to_many.bidirectional.Product;
import com.notes.jpa.cardinalities.one_to_many.unidirectional.OneToManyUnidirectionalClient;
import com.notes.jpa.cardinalities.one_to_one.bidirectional.OneToOneBidirectionalClient;
import com.notes.jpa.cardinalities.one_to_one.unidirectional.Customer;
import com.notes.jpa.cardinalities.one_to_one.unidirectional.OneToOneUnidirectionalClient;
import com.notes.jpa.inheritance.joined_table.JoinedTableClient;
import com.notes.jpa.inheritance.mapped_super_class.MappedSuperClassClient;
import com.notes.jpa.inheritance.single_table.SingleTableClient;
import com.notes.jpa.inheritance.table_per_class.TablePerClassClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
//@EntityScan("com.notes.jpa.cardinalities.one_to_one.unidirectional")
public class NotesApplication implements CommandLineRunner {
    @Autowired
    ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(NotesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //JPAInheritance();
        Cardinalities();
    }

    private void JPAInheritance() {
        //MappedSuperClassRun();
        //TablePerClassRun();
        //SingleTableRun();
        //JoinedTableRun();
    }

    private void Cardinalities() {
        //ONE_TO_ONE
        //OneToOneUnidirectionalRun();
        //OneToOneBidirectionalRun();

        //ONE_TO_MANY
        //OneToManyUnidirectionalRun();
        OneToManyBidirectionalRun();
    }

    private void MappedSuperClassRun() {
        MappedSuperClassClient client = context.getBean(MappedSuperClassClient.class);
        client.saveMentor("deepali", "deepali@123", "M_IT");
        client.saveStudent("utkarsh", "utkarsh@123", "S_IT_B");

    }

    private void TablePerClassRun() {
        TablePerClassClient client = context.getBean(TablePerClassClient.class);
        client.saveMentor("deepali", "deepali@123", "M_IT");
        client.saveStudent("utkarsh", "utkarsh@123", "S_IT_B");
        client.saveUser("ramukaka", "ramukaka@123");
        System.out.printf("---------------- All Users---------------\n");
        client.getAllUsers().forEach(users -> {
            System.out.println(users.getUsername());
        });
    }

    private void SingleTableRun() {
        SingleTableClient client = context.getBean(SingleTableClient.class);
        client.saveMentor("deepali", "deepali@123", "M_IT");
        client.saveStudent("utkarsh", "utkarsh@123", "S_IT_B");
        client.saveUser("ramukaka", "ramukaka@123");
        System.out.printf("---------------- All Users---------------\n");
        client.getAllUsers().forEach(users -> {
            System.out.println(users.getUsername());
        });
        System.out.printf("---------------- All Students---------------\n");
        client.getAllStudentOnly().forEach(users -> {
            System.out.println(users.getUsername());
        });
        System.out.printf("---------------- All Mentors---------------\n");
        client.getAllMentorOnly().forEach(users -> {
            System.out.println(users.getUsername());
        });
    }

    private void JoinedTableRun() {
        JoinedTableClient client = context.getBean(JoinedTableClient.class);
        client.saveMentor("deepali", "deepali@123", "M_IT");
        client.saveStudent("utkarsh", "utkarsh@123", "S_IT_B");
        client.saveUser("ramukaka", "ramukaka@123");
        System.out.printf("---------------- All Users---------------\n");
        client.getAllUsers().forEach(users -> {
            System.out.println(users.getUsername());
        });
        System.out.printf("---------------- All Students---------------\n");
        client.getAllStudentOnly().forEach(users -> {
            System.out.println(users.getUsername());
        });
        System.out.printf("---------------- All Mentors---------------\n");
        client.getAllMentorOnly().forEach(users -> {
            System.out.println(users.getUsername());
        });
        client.deleteUser("utkarsh");
    }

    private void OneToOneUnidirectionalRun() {
        OneToOneUnidirectionalClient client = context.getBean(OneToOneUnidirectionalClient.class);
        client.save();
        List<Customer> result = client.getAllCustomers();
    }

    private void OneToOneBidirectionalRun() {
        OneToOneBidirectionalClient client = context.getBean(OneToOneBidirectionalClient.class);
        client.save();
    }

    private void OneToManyUnidirectionalRun() {
        OneToManyUnidirectionalClient client = context.getBean(OneToManyUnidirectionalClient.class);
        client.save();
    }

    private void OneToManyBidirectionalRun() {
        OneToManyBidirectionalClient client = context.getBean(OneToManyBidirectionalClient.class);
        client.saveCategory();
        Category category = client.getCategory();
        Product product = client.getProduct();
    }


}

package com.javatpoint;
import com.javatpoint.model.Address;
import com.javatpoint.model.Student;
import com.javatpoint.repository.AddressRepository;
import com.javatpoint.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootH2DatabaseExampleApplication 
{
public static void main(String[] args) {
    ConfigurableApplicationContext configurableApplicationContext =
            SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
    AddressRepository addressRepository =
            configurableApplicationContext.getBean(AddressRepository.class);
    StudentRepository studentRepository =
            configurableApplicationContext.getBean(StudentRepository.class);
}
}

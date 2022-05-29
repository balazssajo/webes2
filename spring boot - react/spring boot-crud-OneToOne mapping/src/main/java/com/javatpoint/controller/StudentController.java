package com.javatpoint.controller;
import java.io.FileNotFoundException;
import java.util.List;

import com.javatpoint.model.Address;
import com.javatpoint.repository.AddressRepository;
import com.javatpoint.repository.StudentRepository;
import com.javatpoint.request.StudentRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.javatpoint.model.Student;
import com.javatpoint.service.StudentService;
@Getter
@Setter
@ToString
//creating RestController
@RestController
@CrossOrigin
public class StudentController 
{
//autowired the StudentService class
@Autowired
StudentService studentService;
@Autowired
StudentRepository studentRepository;
@Autowired
private AddressRepository addressRepository;
//creating a get mapping that retrieves all the students detail from the database 
@GetMapping("/student")
private List<Student> getAllStudent(Model model)
{
    model.addAttribute("serverTime", "dateFormat.format(new Date())");
return studentService.getAllStudent();
}
//creating a get mapping that retrieves the detail of a specific student
@GetMapping("/student/{id}")
private Student getStudent(@PathVariable("id") int id) 
{
return studentService.getStudentById(id);
}
//creating a delete mapping that deletes a specific student
@DeleteMapping("/student/{id}")
private void deleteStudent(@PathVariable("id") int id) 
{
studentService.delete(id);
}
//creating post mapping that post the student detail in the database
@PostMapping("/student")
private int saveStudent(@RequestBody StudentRequest sReq)
{
    Address address = new Address();
    address.setStreet(sReq.getStreet());
    address = addressRepository.save(address);

    Student student = new Student(sReq);
    student.setAddress(address);
    student = studentRepository.save(student);


    studentService.saveOrUpdate(student);
    return student.getId();
}
    @CrossOrigin
    @PostMapping("/student/{id}")
    public int updateUser(@PathVariable Integer id, @RequestBody StudentRequest sReq) throws FileNotFoundException {
        Student user=studentRepository.findById(id)
                .orElseThrow(()-> new FileNotFoundException());
        Address address = addressRepository.findById(id-1)
                .orElseThrow(()-> new FileNotFoundException());
        address.setStreet(sReq.getStreet());
        address = addressRepository.save(address);
        user.setAddress(address);
        user.setName(sReq.getName());
        user.setAge(sReq.getAge());
        user.setEmail(sReq.getEmail());

        user = studentRepository.save(user);


        studentService.saveOrUpdate(user);
        Student updatedUser =studentRepository.save(user);
        return user.getId();



    }
}

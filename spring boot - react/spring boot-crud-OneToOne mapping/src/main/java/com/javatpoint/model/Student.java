package com.javatpoint.model;
import com.javatpoint.request.StudentRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

//mark class as an Entity
@Entity
//defining class name as Table name
@Getter
@Setter
@ToString
@Table(name = "Student")
public class Student 
{
//mark id as primary key
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
//defining id as column name
@Column
private int id;
//defining name as column name
@Column
private String name;
//defining age as column name
@Column
private String workplace;
//defining email as column name
@Column
private String email;
@OneToOne
@JoinColumn(name = "address_id", referencedColumnName = "id")
private Address address;

    public Student(String name, String age, String email, Address address) {
        this.name = name;
        this.workplace = age;
        this.email = email;
        this.address = address;
    }

    public Student(StudentRequest sReq) {
        this.name = sReq.getName();
        this.workplace = sReq.getAge();
        this.email = sReq.getEmail();

    }

    public Student() {

    }

    public int getId()
{
return id;
}
public void setId(int id) 
{
this.id = id;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}
public String getAge()
{
return workplace;
}
public void setAge(String age)
{
this.workplace = age;
}
public String getEmail() 
{
return email;
}
public void setEmail(String email) 
{
this.email = email;
}
}
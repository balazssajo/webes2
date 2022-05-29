package com.javatpoint.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

    @Entity
    @Getter
    @Setter
    @ToString
    @Table( name = "Address")
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String street;

        public Address(String street) {
            this.street = street;
        }

        public Address() {

        }
    }


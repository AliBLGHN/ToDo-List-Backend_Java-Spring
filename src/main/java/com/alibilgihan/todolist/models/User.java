    package com.alibilgihan.todolist.models;


    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import javax.persistence.*;


    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Data
    @Table(name = "User")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int uid;

        @Column(name = "username", unique = true)
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "cpassword")
        private String cpassword;
    }

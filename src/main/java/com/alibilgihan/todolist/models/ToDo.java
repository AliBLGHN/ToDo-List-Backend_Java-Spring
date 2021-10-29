    package com.alibilgihan.todolist.models;


    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import javax.persistence.*;


    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Data
    @Table(name = "ToDo")
    public class ToDo {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int tid;

        @Column(name = "text")
        private String text;

        @Column(name = "userid")
        private int userid;

        @Column(name = "status")
        private boolean status;

    }

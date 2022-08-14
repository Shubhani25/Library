package com.reader.Library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reader_id")
    private Integer readerId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "reader_name")
    private String readerName;

    @Column(name = "reader_email")
    private String readerEmail;

    @Column(name = "reader_phone")
    private String readerPhone;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "book_id", nullable = false)
    private List<Book> books = new ArrayList<>();

}

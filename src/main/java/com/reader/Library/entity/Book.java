package com.reader.Library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_id", insertable = false, updatable = false)
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;
}

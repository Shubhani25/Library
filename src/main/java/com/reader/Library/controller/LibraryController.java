package com.reader.Library.controller;

import com.reader.Library.entity.Reader;
import com.reader.Library.entity.Book;
import com.reader.Library.service.LibraryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library_api/v1")
public class LibraryController {

    private final LibraryService libraryService;
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("fetch_book_by_book_id/{book_id}")
    public Book fetchBookByBookId(@Validated @PathVariable("book_id") Integer bookId) {
        return libraryService.fetchBookByBookId(bookId);
    }

    @GetMapping("/fetch_reader_by_id/{reader_id}")
    public List<Reader> fetchReaderByReaderId(@Validated @PathVariable("reader_id") Integer readerId) {
        return libraryService.fetchReaderByReaderId(readerId);
    }

    @GetMapping("/fetch_by_reader_id_and_book_id/{reader_id}/{book_id}")
    public Reader fetchByReaderIdAndBookId(@Validated @PathVariable("reader_id") Integer readerId, @Validated @PathVariable("book_id") Integer bookId) {
        return libraryService.fetchByReaderIdAndBookId(readerId, bookId);
    }

    @PostMapping
    public Reader saveReader(@Validated @RequestBody Reader reader) {
        return libraryService.saveReader(reader);
    }

    @DeleteMapping("delete_by_reader_id_book_id/{reader_id}/{book_id}")
    public void deleteByReaderIdAndBookId(@Validated @PathVariable("reader_id") Integer readerId, @Validated @PathVariable("book_id") Integer bookId) {
        libraryService.deleteByReader(readerId, bookId);
    }
}

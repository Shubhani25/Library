package com.reader.Library.service;

import com.reader.Library.entity.Reader;
import com.reader.Library.entity.Book;
import com.reader.Library.repository.BookRepository;
import com.reader.Library.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    public LibraryService(BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    public Book fetchBookByBookId(Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Reader> fetchReaderByReaderId(Integer readerId) {
        return readerRepository.findByReaderId(readerId);
    }

    public Reader fetchByReaderIdAndBookId(Integer readerId, Integer bookId) {
        return readerRepository.findByReaderIdAndBookId(readerId, bookId);
    }

    public Reader saveReader(Reader reader) {
        Reader savedReader=null;
        Reader existingReader = readerRepository.findByReaderIdAndBookId(reader.getReaderId(), reader.getBookId());
        if(null == existingReader){
            savedReader = readerRepository.save(reader);
        }
        return savedReader;
    }

    public void deleteByReader(Integer readerId, Integer bookId) {
        Reader existingReader = readerRepository.findByReaderIdAndBookId(readerId, bookId);
        if(null != existingReader){
            readerRepository.delete(existingReader);
        }
    }
}

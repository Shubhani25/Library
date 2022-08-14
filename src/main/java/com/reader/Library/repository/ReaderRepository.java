package com.reader.Library.repository;

import com.reader.Library.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    Reader findByReaderIdAndBookId(Integer readerId, Integer bookId);

    List<Reader> findByReaderId(Integer readerId);
}


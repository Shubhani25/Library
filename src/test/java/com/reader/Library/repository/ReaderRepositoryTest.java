package com.reader.Library.repository;

import com.reader.Library.LibraryApplication;
import com.reader.Library.entity.Reader;
import com.reader.Library.utility.JsonUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LibraryApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ReaderRepositoryTest {

    @Autowired
    ReaderRepository readerRepository;

    private static final String LIBRARY_JSON_FILE_PATH = "/libraryData.json";


}

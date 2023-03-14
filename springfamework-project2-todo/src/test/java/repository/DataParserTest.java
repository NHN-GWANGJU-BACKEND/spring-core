package repository;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.parser.CsvDataParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;

import java.util.Collection;

public class DataParserTest {

    @InjectMocks
    private CsvDataParser csvDataParser;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readFile(){
        Collection<Bill> test = csvDataParser.readFile();
        Assertions.assertThat(test).isNotEmpty();
    }


}

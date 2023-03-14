package repository;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.parser.CsvDataParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Collection;

public class DataParserTest {

    @InjectMocks
    private CsvDataParser csvDataParser;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readFile() {
        String path = "/src/main/resources/Tariff_20220331.csv";

        Collection<Bill> test = csvDataParser.readFile(path);
        Assertions.assertThat(test).isNotEmpty();
    }


}

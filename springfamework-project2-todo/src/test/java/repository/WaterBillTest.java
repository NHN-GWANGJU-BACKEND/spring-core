package repository;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.CsvWaterBill;
import com.nhnacademy.edu.project.repository.parser.CsvDataParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class WaterBillTest {
    @InjectMocks
    CsvWaterBill csvWaterBill;

    @InjectMocks
    CsvDataParser csvDataParser;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        csvWaterBill.setCsvDataParser(csvDataParser);
    }

    @Test
    void load(){
        Assertions.assertThat(csvWaterBill.load()).isTrue();
    }

    @Test
    void findTicketByUsage(){
        csvWaterBill.load();

        List<Bill> test = csvWaterBill.findTicketByUsage(1000);
        List<Bill> test2 = csvWaterBill.findTicketByUsage(0);

        Assertions.assertThat(test.size()).isNotEqualTo(test2.size()); // 가
    }
}

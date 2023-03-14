package service;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.CsvWaterBill;
import com.nhnacademy.edu.project.repository.parser.CsvDataParser;
import com.nhnacademy.edu.project.service.DefaultUsageWaterworks;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UsageWaterTest {

    @InjectMocks
    DefaultUsageWaterworks defaultUsageWaterworks;

    @InjectMocks
    CsvWaterBill csvWaterBill;

    @InjectMocks
    CsvDataParser csvDataParser;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        defaultUsageWaterworks.setCsvWaterBill(csvWaterBill);
        csvWaterBill.setCsvDataParser(csvDataParser);
    }

    @Test
    void calculateUsagePrice(){
        long usage = 1000;

        csvWaterBill.load();
        List<Bill> originWaterBill = csvWaterBill.findTicketByUsage(usage);
        List<Bill> changeWaterBill = defaultUsageWaterworks.calculateUsagePrice(usage);

        Assertions.assertThat(changeWaterBill.get(0).getTotalPrice()).isNotEqualTo(originWaterBill.get(0).getTotalPrice());

    }
}

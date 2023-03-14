package service;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.FormatWaterBill;
import com.nhnacademy.edu.project.repository.parser.CsvDataParser;
import com.nhnacademy.edu.project.repository.parser.DataParser;
import com.nhnacademy.edu.project.repository.parser.JsonDataParser;
import com.nhnacademy.edu.project.service.DefaultUsageWaterworks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UsageWaterTest {

    @InjectMocks
    DefaultUsageWaterworks defaultUsageWaterworks;
    @InjectMocks
    FormatWaterBill formatWaterBill;
    @Mock
    List<DataParser> dataParsers;

    CsvDataParser csvDataParser;
    JsonDataParser jsonDataParser;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        defaultUsageWaterworks.setCsvWaterBill(formatWaterBill);
        dataParsers = new ArrayList<>();
        csvDataParser = new CsvDataParser();
        jsonDataParser = new JsonDataParser();
        dataParsers.add(csvDataParser);
        dataParsers.add(jsonDataParser);
        formatWaterBill.setDataParsers(dataParsers);
    }

    @Test
    void calculateUsagePrice(){
        long usage = 1000;
        String path = "/src/main/resources/Tariff_20220331.json";
        String format = path.split("\\.")[1];

        formatWaterBill.load(path,format);
        List<Bill> originWaterBill = formatWaterBill.findTicketByUsage(usage);
        List<Bill> changeWaterBill = defaultUsageWaterworks.calculateUsagePrice(usage);

        Assertions.assertThat(changeWaterBill.get(0).getTotalPrice()).isNotEqualTo(originWaterBill.get(0).getTotalPrice());

    }
}

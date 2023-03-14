package repository;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.FormatWaterBill;
import com.nhnacademy.edu.project.repository.parser.CsvDataParser;
import com.nhnacademy.edu.project.repository.parser.DataParser;
import com.nhnacademy.edu.project.repository.parser.JsonDataParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WaterBillTest {
    @InjectMocks
    FormatWaterBill formatWaterBill;
    @Mock
    List<DataParser> dataParsers;

    CsvDataParser csvDataParser;
    JsonDataParser jsonDataParser;

    private String path = "/src/main/resources/Tariff_20220331.json";
    private String format = path.split("\\.")[1];


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        dataParsers = new ArrayList<>();
        csvDataParser = new CsvDataParser();
        jsonDataParser = new JsonDataParser();
        dataParsers.add(csvDataParser);
        dataParsers.add(jsonDataParser);
        formatWaterBill.setDataParsers(dataParsers);
    }

    @Test
    void load(){
        Assertions.assertThat(formatWaterBill.load(path,format)).isTrue();
    }

    @Test
    void findTicketByUsage(){
        formatWaterBill.load(path,format);

        List<Bill> test = formatWaterBill.findTicketByUsage(1000);
        List<Bill> test2 = formatWaterBill.findTicketByUsage(0);

        Assertions.assertThat(test.size()).isNotEqualTo(test2.size()); // 가
    }
}

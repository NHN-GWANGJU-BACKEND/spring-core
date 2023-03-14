package service;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.service.ReportResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ReportResultTest {
    @InjectMocks
    ReportResult reportResult;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void showResult(){
        List<Bill> waterBill = new ArrayList<>();
        waterBill.add(new Bill("광주","서구",1,30,300));
        waterBill.add(new Bill("광주","동구",1,30,300));
        waterBill.add(new Bill("광주","북구",1,30,300));

        Assertions.assertThat(reportResult.showResult(waterBill)).isTrue();
    }

}

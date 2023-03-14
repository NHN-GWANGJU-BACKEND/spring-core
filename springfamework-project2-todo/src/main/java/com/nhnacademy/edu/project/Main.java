package com.nhnacademy.edu.project;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.CsvWaterBill;
import com.nhnacademy.edu.project.repository.WaterBill;
import com.nhnacademy.edu.project.service.DefaultUsageWaterworks;
import com.nhnacademy.edu.project.service.IDefaultUsageWaterworks;
import com.nhnacademy.edu.project.service.IReportResult;
import com.nhnacademy.edu.project.service.ReportResult;
import com.nhnacademy.edu.project.service.log.LogService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String basePackage = "com.nhnacademy.edu.project";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(basePackage);
        LogService logService = new LogService();

        long usage = getUsage(logService);

        WaterBill csvWaterBill = context.getBean("csvWaterBill",CsvWaterBill.class);
        csvWaterBill.load();

        IDefaultUsageWaterworks defaultUsageWaterworks =
                context.getBean("defaultUsageWaterworks",DefaultUsageWaterworks.class);
        List<Bill> showResult = defaultUsageWaterworks.calculateUsagePrice(usage);

        IReportResult reportResult = context.getBean("reportResult",ReportResult.class);
        reportResult.showResult(showResult);

        logService.info("===================================================================================\n");

    }

    private static long getUsage(LogService logService) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("사용량 입력 (limit : 10억) > ");
        long usage = Long.parseLong(br.readLine());
        try{
            if(usage>=1000000000){
                throw new NumberFormatException();
            }
            logService.info("사용량 "+usage+"(톤)에 따른 상수도요금 오름차순 랭킹 5\n");
        }catch (NumberFormatException e){
            System.out.println("10억톤 이상의 사용량은 지원하지 않습니다");
            System.exit(0);
        }
        return usage;
    }
}
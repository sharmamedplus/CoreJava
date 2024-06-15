package com.java.designpatterns.facade;

import com.java.designpatterns.facade.impl.ExcelPrinterImpl;
import com.java.designpatterns.facade.impl.PdfPrinterImpl;

public class FacadeTest {
    public static void main(String[] args) {

        PdfPrinter pdfPrinter = new PdfPrinterImpl();
        ExcelPrinter excelPrinter = new ExcelPrinterImpl();

        FacadeCLass cLass = new FacadeCLass(pdfPrinter, excelPrinter);
        cLass.printPdf();
        cLass.printExcel();
    }
}

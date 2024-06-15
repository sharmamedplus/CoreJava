package com.java.designpatterns.facade;

public class FacadeCLass {

    PdfPrinter pdfPrinter;
    ExcelPrinter excelPrinter;

    public FacadeCLass(PdfPrinter pdfPrinter, ExcelPrinter excelPrinter){
        this.pdfPrinter = pdfPrinter;
        this.excelPrinter = excelPrinter;
    }

    public void printPdf(){
        pdfPrinter.printPdfReport();
    }

    public void printExcel(){
        excelPrinter.printExcelReport();
    }
}

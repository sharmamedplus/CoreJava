package com.java.designpatterns.facade.impl;

import com.java.designpatterns.facade.ExcelPrinter;

public class ExcelPrinterImpl implements ExcelPrinter {

    @Override
    public void printExcelReport() {
        System.out.println("Printing Excel");
    }
}

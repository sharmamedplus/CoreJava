package com.java.designpatterns._2structural.facade.impl;

import com.java.designpatterns._2structural.facade.ExcelPrinter;

public class ExcelPrinterImpl implements ExcelPrinter {

    @Override
    public void printExcelReport() {
        System.out.println("Printing Excel");
    }
}

package com.java.designpatterns.facade.impl;

import com.java.designpatterns.facade.PdfPrinter;

public class PdfPrinterImpl implements PdfPrinter {
    @Override
    public void printPdfReport() {
        System.out.println("Printing PDF");
    }
}

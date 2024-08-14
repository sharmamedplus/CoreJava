package com.java.designpatterns._2structural.facade.impl;

import com.java.designpatterns._2structural.facade.PdfPrinter;

public class PdfPrinterImpl implements PdfPrinter {
    @Override
    public void printPdfReport() {
        System.out.println("Printing PDF");
    }
}

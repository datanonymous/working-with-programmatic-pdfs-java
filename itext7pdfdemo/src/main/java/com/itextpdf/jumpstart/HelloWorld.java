package com.itextpdf.jumpstart;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Requires:
itext7 io jar
itext7 kernal jar
itext7 layout jar
slf4j api
slf4j simple
// https://stackoverflow.com/questions/12926899/java-lang-noclassdeffounderror-org-slf4j-loggerfactory
// https://www.slf4j.org/download.html
 */

public class HelloWorld {

    public static final String DEST="results/chapter01/hello_world.pdf";

    public static void main(String[] args) throws IOException{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new HelloWorld().createPdf(DEST);
    }

    public void createPdf(String destination) throws IOException{
        //Initialize PDF writer
        FileOutputStream fos = new FileOutputStream(DEST);
        PdfWriter writer = new PdfWriter(fos);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        //Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the content
        document.add(new Paragraph("Hello World"));

        //Close document
        document.close();
    }

}

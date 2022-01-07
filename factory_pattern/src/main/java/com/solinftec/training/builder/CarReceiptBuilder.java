package com.solinftec.training.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class CarReceiptBuilder {
    private static final String LINE_BREAK = System.getProperty("line.separator");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private final StringBuilder receipt;
    private int printColumns = 50;
    private int printParagraphSize = 3;

    public CarReceiptBuilder(StringBuilder receipt) {
        this.receipt = receipt;
    }

    public CarReceiptBuilder() {
        this(new StringBuilder());
    }

    public CarReceiptBuilder setPrintColumns(int printColumns) {
        this.printColumns = printColumns;
        return this;
    }

    public CarReceiptBuilder setPrintParagraphSize(int printParagraphSize) {
        this.printParagraphSize = printParagraphSize;
        return this;
    }

    public CarReceiptBuilder appendHeader() {
        return this.appendSeparatorLine()
            .appendParagraphLine("Congratulations on your new car purchase!")
            .appendSeparatorLine();
    }

    public CarReceiptBuilder appendDateLine() {
        return this.appendDetailLine("Date", dateFormatter.format(LocalDateTime.now()), ' ');
    }

    public CarReceiptBuilder appendSeparatorLine() {
        receipt.append(StringUtils.repeat("=", printColumns)).append(LINE_BREAK);
        return this;
    }

    public CarReceiptBuilder appendLineBreak() {
        receipt.append(LINE_BREAK);
        return this;
    }

    public CarReceiptBuilder appendDetailLine(String key, String value) {
        return appendDetailLine(key, value, '.');
    }

    public CarReceiptBuilder appendDetailLine(String key, String value, char fillerChar) {
        var line = "";
        line += key + ":";
        for (int x = 0, count = (printColumns - line.length() - value.length()); x < count; x++) {
            line += fillerChar;
        }
        line += value;
        receipt.append(line).append(LINE_BREAK);
        return this;
    }

    public CarReceiptBuilder appendParagraphLine(String paragraphText) {
        var line = "";
        //Adiciona espaços em branco representando o início do parágrafo
        paragraphText = StringUtils.repeat(" ", printParagraphSize) + paragraphText;
        var printedCount = 0;
        var totalCharsToPrint = paragraphText.length();
        while(printedCount < totalCharsToPrint){
            line += paragraphText.charAt(printedCount);
            /*Se a linha atingir o tamanho máximo, adiciona a
            linha existente ao recibo e reseta a variabel "line"*/
            if (line.length() == printColumns){
                receipt.append(line).append(LINE_BREAK);
                line = "";
            }            
            printedCount++;
        }
        if (line.length() > 0){
            receipt.append(line).append(LINE_BREAK);
        }
        return this;
    }

    public CarReceiptBuilder appendFooter() {
        return this.appendSeparatorLine();
    }

    public String build() {
        return receipt.toString();
    }
}

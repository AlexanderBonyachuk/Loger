package com.company;

import com.company.businessLogic.FileReader;
import com.company.businessLogic.MyReader;

public class App {
    public static void main(String[] args) {
        MyReader reader = new FileReader();
        String message = reader.read();
        System.out.println(message);
    }
}

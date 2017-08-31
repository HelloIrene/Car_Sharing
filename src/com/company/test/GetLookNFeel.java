package com.company.test;

import com.company.changSkin.ShowSystemLookNFeelClass;

import java.awt.*;

public class GetLookNFeel {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShowSystemLookNFeelClass showSystemLookNFeelClass = new ShowSystemLookNFeelClass();
                showSystemLookNFeelClass.setVisible(true);
            }
        });
    }
}

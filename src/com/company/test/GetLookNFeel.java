package com.company.test;

import com.company.changSkin.ShowSystemLookNFeelClass;
import com.company.frame.Login;

import java.awt.*;

public class GetLookNFeel {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}

package com.company.test;

import com.company.editCarInformation.EditCarInfFrame;

import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        EditCarInfFrame frame = new EditCarInfFrame();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


}

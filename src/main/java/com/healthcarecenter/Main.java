package com.healthcarecenter;

import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.FileUtils;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        if(!FileUtils.hasAllNeededFolders()){
            JOptionPane.showMessageDialog(null, "Missing required folders. Maybe Permission Denied.");
        } else{
            FrameUtils.defaultFrame();
        }
    }
}

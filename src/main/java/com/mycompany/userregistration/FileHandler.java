/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.userregistration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Random;
/**
 *
 * @author ROOT
 */
public class FileHandler implements CurrentUser {
    User theUser;
    public void saveToLog(String thePath) throws IOException {
         File log = new File(thePath);
            BufferedWriter bufferedWriter = null;
            FileWriter fileWriter = null;
            try{
                if(!log.exists()) {
                    log.createNewFile();
                }
                fileWriter = new FileWriter(log,true);
                bufferedWriter = new BufferedWriter((fileWriter));
                bufferedWriter.newLine();
                bufferedWriter.append("#");
                bufferedWriter.append(theUser.getEmail());
                 bufferedWriter.newLine();
                bufferedWriter.append(theUser.getUserName());
                bufferedWriter.append(" ");
                bufferedWriter.append("Cleartext-password :=");
                bufferedWriter.append("\"");
                bufferedWriter.append(theUser.getPwd2());
                bufferedWriter.append("\"");
                
                bufferedWriter.newLine();
                
           } catch (IOException e) {

			e.printStackTrace();

		} 
            finally {
                if (bufferedWriter != null)
			bufferedWriter.close();

		if (fileWriter != null)
                       fileWriter.close();
            }
    }
    
    public void userHash(String thePath) throws IOException {
        File log = new File(thePath);
            BufferedWriter bufferedWriter = null;
            FileWriter fileWriter = null;
//            Random random = new Random();
            
//            String passCode = Integer.toString(random.nextInt(10000));
            try{
                if(!log.exists()) {
                    log.createNewFile();
                }
                fileWriter = new FileWriter(log,true);
                bufferedWriter = new BufferedWriter((fileWriter));
                bufferedWriter.newLine();
                bufferedWriter.append(theUser.getVerifyCode());
                bufferedWriter.append(":");
                bufferedWriter.append(theUser.getEmail());
                bufferedWriter.append(":");
                bufferedWriter.append(theUser.getUserName());
                bufferedWriter.append(":");
                bufferedWriter.append(theUser.getPwd2());
                bufferedWriter.append(":");
                bufferedWriter.append(theUser.getName());
                
                
           } catch (IOException e) {

			e.printStackTrace();

		} 
            finally {
                if (bufferedWriter != null)
			bufferedWriter.close();

		if (fileWriter != null)
                       fileWriter.close();
            }
        
    }
    
    public User readUserHash(String thePath,String Code){
        
        File log=new File(thePath);
        BufferedReader buffer = null;
        FileInputStream input = null;
        User returnUser = new User();
        int numberOfLines = 0;
        try {
            input = new FileInputStream(thePath);
            buffer = new BufferedReader(new InputStreamReader(input));
            
            while((buffer.readLine()) != null) {
                numberOfLines++;
            }
            
            input.getChannel().position(0);
            String inputBuffer;
            for(int i=0; i<numberOfLines; i++) {
                inputBuffer = buffer.readLine();
                
                if(inputBuffer.contains(Code)) {
                    String[] split = inputBuffer.split(":");
                    returnUser.setVerifyCode(split[0]);
                    returnUser.setEmail(split[1]);
                    returnUser.setUserName(split[2]);
                    returnUser.setPwd2(split[3]);
                    returnUser.setName(split[4]);
                    return returnUser;
                    
                }
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setCurrentUser(User currentUser) {
        theUser = currentUser;
    }
}

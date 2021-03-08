/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteminventory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ravi
 */

public class FieldValidation {
    final static private String emailPattern="^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    final static private String namePattern="^[a-zA-Z ]{3,30}$";
    final static private String mobilePattern="^\\d{10}$";
    final static private String pattern="^[a-zA-Z0-9 ]{1,20}$";
    final static private String address="^[a-zA-Z0-9-,&. ]{1,80}$";
    
    public static boolean validateEmail(String str)
    {
        Pattern pattern=Pattern.compile(emailPattern);
        Matcher matcher=pattern.matcher(str);
        if(!matcher.matches())
            return true;
        
        return false;
    }
    public static boolean validateName(String str)
    {
        Pattern pattern=Pattern.compile(namePattern);
        Matcher matcher=pattern.matcher(str);
        if(!matcher.matches())
            return true;
        
        return false;
    }
    public static boolean validateMobileNo(String str)
    {
        Pattern pattern=Pattern.compile(mobilePattern);
        Matcher matcher=pattern.matcher(str);
        if(!matcher.matches())
            return true;
        
        return false;
    }
    public static boolean validateAllPattern(String str)
    {
        Pattern pattern=Pattern.compile(FieldValidation.pattern);
        Matcher matcher=pattern.matcher(str);
        if(!matcher.matches())
            return true;
        
        return false;
    }
    public static boolean validateAddress(String str)
    {
        Pattern pattern=Pattern.compile(FieldValidation.address);
        Matcher matcher=pattern.matcher(str);
        if(!matcher.matches())
            return true;
        
        return false;
    }
}

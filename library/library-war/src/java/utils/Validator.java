/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author saurya
 */
public abstract class Validator {
    
    protected LinkedHashMap <String, String> errors;
    
    protected LinkedHashMap <String, String> data;
    
    
    public Validator()
    {
        errors = new LinkedHashMap();
        data = new LinkedHashMap();
    }
    
    public String getErrorMessage(String key)
    {
        String msg = (String)errors.get(key);
        return (msg == null) ? "" : msg;
    }
    
    public void setErrorMessage(String key, String message)
    {
        errors.put(key, message);
    }
    
    public void addFormData(String key, String value)
    {
        data.put(key, value);
    }
    
    public abstract boolean validateForm();
}

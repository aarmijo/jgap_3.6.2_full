/*
 * WunderException.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.connector;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: WunderException.java 27-01-2012 10:10:07 ttravnicek
 */
public class WunderException extends Exception {

    public static final int ERROR_WUNDER_ERROR = 1000;
    public static final int ERROR_IO_ERROR = 1001;
    public static final int ERROR_JSON_PARSE_ERROR = 1002;
    public static final String WUNDER_EXCEPTION = "WunderException";
    
    private int errorCode = 0;
    private String errorText = null;
    private String errorDescription = null;

    public WunderException() {
        this(WUNDER_EXCEPTION);
    }

    public WunderException(String errorText) {
        super(errorText);
        this.errorText = errorText;
    }

    public WunderException(int errorCode, String errorText) {
        super(errorText);
        this.errorText = errorText;
        this.errorCode = errorCode;
    }

    public WunderException(int errorCode, String errorText, String errorDescrption) {
        super(errorText);
        this.errorText = errorText;
        this.errorCode = errorCode;
        this.errorDescription = errorDescrption;
    }

    public WunderException(WunderException e) {
        super(e.getErrorText());
        this.errorText = e.getErrorText();
        this.errorCode = e.getErrorCode();
        this.errorDescription = e.getErrorDescription();
    }

    public WunderException(Exception e) {
        super(e.getMessage());
        this.errorText = e.getMessage();
        this.errorCode = ERROR_WUNDER_ERROR;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
    
}

package com.example.fourthworksheet.exception;

import java.util.Date;

public class ExceptionResponse {

    public Date errorDate;

    public String errorMessage;

    public String errorDetail;

    public ExceptionResponse(Date errorDate, String errorMessage, String errorDetail) {
        this.errorDate = errorDate;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    public ExceptionResponse() {
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}

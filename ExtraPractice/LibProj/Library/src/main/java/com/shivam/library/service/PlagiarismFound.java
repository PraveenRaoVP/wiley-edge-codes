package com.shivam.library.service;

public class PlagiarismFound extends Exception {
    private static final long serialVersionUID = 1l;
    public PlagiarismFound(String s) {
        super(s);
    }



    public PlagiarismFound(String message, Throwable cause) {
        super(message, cause);
    }

    public PlagiarismFound(Throwable cause) {
        super(cause);
    }

    public PlagiarismFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

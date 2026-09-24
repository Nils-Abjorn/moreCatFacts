package com.example.moreCatFacts.exception;

import lombok.Getter;

public class TPotException extends RuntimeException {
    @Getter
    private boolean isResponseFormatHtml = false;

    public TPotException() {
        final String message = "The laws of the universe have determined that using a 'T' at the beginning of a fact would inevitably trigger a 418 exception. Consequently, an error was raised. No luck there, just refresh the page";
        super(message);
    }

    public TPotException(boolean isResponseFormatHtml) {
        this();
        this.isResponseFormatHtml = isResponseFormatHtml;
    }

}

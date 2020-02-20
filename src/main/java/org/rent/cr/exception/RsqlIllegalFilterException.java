package org.rent.cr.exception;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;

public class RsqlIllegalFilterException extends RuntimeException {
    public RsqlIllegalFilterException(String message) {
        super(message);
    }

    //TODO try to send error message like this
//    public RsqlOperatorException(String property, ComparisonOperator operator) {
//        super("Operator [" + operator + "] not supported for field [" + property + "]");
//    }
}

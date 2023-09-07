package com.serivce.goodService.first_service.utility;

import org.springframework.stereotype.Component;

@Component
public class GoodUtility {

    private static String[] parsedArr;

    public static String[] parsingMethod(String targetArg){
        return targetArg.split(" ");
    }

}

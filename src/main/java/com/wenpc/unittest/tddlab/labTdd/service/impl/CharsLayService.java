package com.wenpc.unittest.tddlab.labTdd.service.impl;

import com.wenpc.unittest.tddlab.labTdd.service.ICharsLayService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

@Service
public class CharsLayService implements ICharsLayService {

    public List<String> lay(String input) {
        if (input.length() == 1) {
            return asList(input) ;
        }

//        if (input.length() == 2){
//            return asList(input,reverse(input));
//        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            List<String> charsLayLeft = lay(dropChar(input,i));
            for (String s : charsLayLeft) {
                result.add(input.charAt(i) + s);
            }
        }
        return result;
//            return asList(
//                    input.charAt(0) + lay(dropChar(input,0)).get(0),
//                    input.charAt(0) + lay(dropChar(input,0)).get(1),
//
//                    input.charAt(1) + lay(dropChar(input,1)).get(0),
//                    input.charAt(1) + lay(dropChar(input,1)).get(1),
//
//                    input.charAt(2) + lay(dropChar(input,2)).get(0),
//                    input.charAt(2) + lay(dropChar(input,2)).get(1)
//            );
    }

    /**
     * 删除指定位置字母
     * @param input
     * @return
     */
    private static String dropChar(String input,int index) {
        return new StringBuilder(input).deleteCharAt(index).toString();
    }

//    /**
//     * 反序
//     * @param input
//     * @return
//     */
//    private static String reverse(String input) {
//        return new StringBuilder(input).reverse().toString();
//    }


}

package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Underscore2CamelCase {
	
	public static void main(String[] args) {
		String[] namearr = {
				"Id",
				"userId",
				"idCard",
				"city",
				"isSingle",
				"ADDRESS",
				"havePC",
		};
		System.out.println(underscore2CamelCase(Arrays.asList(namearr)));;
	}

	public static List<String> underscore2CamelCase(List<String> nameList){

        List<String> resultList = nameList.stream().map(name -> {
            StringBuilder result = new StringBuilder();
            boolean preIsLowerCase = false;
            for (char c : name.toCharArray()) {
                if (Character.isLowerCase(c)){
                    preIsLowerCase = true;
                    result.append(c);
                }
                else if (Character.isUpperCase(c)){
                    if(preIsLowerCase){
                        result.append("_").append(Character.toLowerCase(c));
                    } else {
                    	/*
                    	 * output:
                    	 * [id, user_id, id_card, city, is_single, address, have_pc]
                    	 */
                        result.append(Character.toLowerCase(c));
                    }
                    
                	/*
                	 * output:
                	 * [Id, user_id, id_card, city, is_single, ADDRESS, havePC]
                	 */
//                    else {
//                        int len = result.length();
//                        if(len > 1){
//                            char preChar = result.charAt(len - 1);
//                            if(Character.isLowerCase(preChar)){
//                                result.delete(len - 2, len);
//                                result.append(Character.toUpperCase(preChar));
//                            }
//                        }
//                        result.append(c);
//                    }
                    preIsLowerCase = false;
                }
            }
            return result.toString();
        }).collect(Collectors.toList());
        return resultList;
		
	}
}
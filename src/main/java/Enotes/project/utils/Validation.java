package Enotes.project.utils;

import Enotes.project.Exception.ValidationException;
import Enotes.project.dto.CategoryDto;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Validation {
Map<String,Object> error=new LinkedHashMap<>();
    public void  categoryValidation(CategoryDto categoryDto){

        if(ObjectUtils.isEmpty(categoryDto)){
            throw  new IllegalArgumentException("category should not be empty");
        }
        else {
            // for name validation
            if(ObjectUtils.isEmpty(categoryDto.getName())){
                error.put("name","name should not be empty");
            }
            else {
                if (categoryDto.getName().length()<10){
                    error.put("name","name should be atleast 5 ");
                }
                if (categoryDto.getName().length()>100){
                    error.put("name","name should not more than 100 ");
                }

            }
            // validating description
            if(ObjectUtils.isEmpty(categoryDto.getDescription())){
                error.put("description","description should not be empty should not be empty");
            }
            else {
                if (categoryDto.getDescription().length()<10){
                    error.put("description","description should be atleast 15 ");
                }
                if (categoryDto.getDescription().length()>100){
                    error.put("description","description should not more than 150 ");
                }

            }


        }

        if(!error.isEmpty()){
            throw  new ValidationException(error);
        }
    }
}

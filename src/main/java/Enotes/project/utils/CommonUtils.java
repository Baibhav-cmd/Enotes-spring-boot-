package Enotes.project.utils;

import Enotes.project.dto.CategoryResponse;
import Enotes.project.dto.NoteDto;
import Enotes.project.hanlder.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CommonUtils {
    public static ResponseEntity<?> createBuilderResponse(Object data, HttpStatus status){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("sucess")
                .message("user create sucess")
                .data(data)
        .build();
        return response.create();
    }
    public static ResponseEntity<?> createBuilderResponseMessage( HttpStatus status,String message){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("sucess")
                .message(message)
                .build();
        return response.create();
    }
    public static ResponseEntity<?> createErrorResponse(Object data, HttpStatus status){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("failed")
                .message("failed")
                .build();
        return response.create();
    }
    public static ResponseEntity<?> createdErrorResponseMessage( HttpStatus status,String message){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("failed")
                .message(message)
                .build();
        return response.create();
    }

    public static ResponseEntity<?> createSuccessResponse(List<CategoryResponse> categories, HttpStatus httpStatus, String categoriesFetchedSuccessfully) {
    GenericResponse response=GenericResponse.builder()
            .responseStatus(httpStatus)
            .data(categories)
            .message(categoriesFetchedSuccessfully)
            .build();
    return response.create();
    }
    public static ResponseEntity<?> createSuccessResponseNote(List<NoteDto> categories, HttpStatus httpStatus, String categoriesFetchedSuccessfully) {
        GenericResponse response=GenericResponse.builder()
                .responseStatus(httpStatus)
                .data(categories)
                .message(categoriesFetchedSuccessfully)
                .build();
        return response.create();
    }
}

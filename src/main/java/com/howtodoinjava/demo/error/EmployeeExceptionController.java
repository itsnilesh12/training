//package com.howtodoinjava.demo.error;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class EmployeeExceptionController {
//  @ExceptionHandler(value = EmployeeNotFound.class)
//   public ResponseEntity<Object> exception(EmployeeNotFound exception) {
//      return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
//   }
//}
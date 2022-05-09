package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import com.bridgelabz.addressbookapp.services.IAddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {

    @Autowired
    IAddressbookService addressbooService;

    @RequestMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
        AddressbookData addressbookData = null;
        addressbookData = addressbooService.getAddressbookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id is successfully",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = addressbooService.createAddressbooData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId,@RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData = null;
        addressbookData = addressbooService.updateAddressbookData(personId,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        addressbooService.deleteAddressbooData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}

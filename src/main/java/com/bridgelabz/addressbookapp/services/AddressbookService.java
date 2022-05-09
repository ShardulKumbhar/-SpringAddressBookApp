package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookService implements IAddressbookService {

    /**
     * Used arraylist to Store the data
     */
    List<AddressbookData> addressbookDataList = new ArrayList<>();

    /**
     * Method to get all stored data
     * @return
     */
    @Override
    public List<AddressbookData> getAddressbookData() {
        return addressbookDataList;
    }

    /**
     * Method to get indiviual data by id
     * @param personId
     * @return
     */
    @Override
    public AddressbookData getAddressbookDataById(int personId) {
        AddressbookData addressbookData = null;
        addressbookData = addressbookDataList.get(personId - 1);
        return addressbookData;
    }

    /**
     * Method to store Address book data into Array
     * @param addressbookDTO
     * @return
     */
    @Override
    public AddressbookData createAddressbooData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(addressbookDataList.size() + 1, addressbookDTO);
        addressbookDataList.add(addressbookData);
        return addressbookData;
    }

    /**
     * Method to update Data stored in array
     */
    @Override
    public AddressbookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = this.getAddressbookDataById(personId);
        addressbookData.setName(addressbookDTO.name);
        addressbookData.setPhNumber(addressbookDTO.phNumber);
        addressbookDataList.set(personId - 1, addressbookData);
        return addressbookData;
    }

    /**
     * Method to delete data in array
     * @param personId
     */
    @Override
    public void deleteAddressbooData(int personId) {
        int i = 1;
        addressbookDataList.remove(personId - 1);
        for (AddressbookData addressbookData : addressbookDataList) {
            addressbookData.setPersonId(i++);
        }
    }
}

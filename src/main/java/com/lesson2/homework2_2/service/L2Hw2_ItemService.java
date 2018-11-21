package com.lesson2.homework2_2.service;

import com.lesson2.homework2_2.dao.L2hw2_ItemDAO;
import com.lesson2.homework2_2.exception.BadRequestException;
import com.lesson2.homework2_2.exception.InternalServerError;
import com.lesson2.homework2_2.model.L2hw2_Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class L2Hw2_ItemService {

    private L2hw2_ItemDAO itemDAO;

    @Autowired
    public L2Hw2_ItemService(L2hw2_ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public L2hw2_Item save(L2hw2_Item item) throws InternalServerError, BadRequestException {
        validateItem(item);

        item.setDateCreated(new Date());
        item.setLastUpdatedDate(new Date());
        return itemDAO.save(item);
    }

    public L2hw2_Item update(L2hw2_Item item) throws InternalServerError, BadRequestException {
        validateItem(item);

        item.setLastUpdatedDate(new Date());
        return itemDAO.update(item);
    }

    public L2hw2_Item delete(Long id) throws InternalServerError, BadRequestException {
        L2hw2_Item item = itemDAO.findById(id);
        if(item == null)
            throw new BadRequestException("There is no item with id: "+id);

        return itemDAO.delete(item);
    }

    public L2hw2_Item findById(Long id) throws InternalServerError, BadRequestException{
        L2hw2_Item item = itemDAO.findById(id);
        if(item != null)
            return item;
        throw new BadRequestException("There is no item with id: "+id);
    }

    private void validateItem(L2hw2_Item item) throws InternalServerError , BadRequestException {
        if(item.getName().equals(""))
            throw new BadRequestException("Item name can not be empty");
        if(itemDAO.findByName(item.getName()) != null)
            throw new BadRequestException("Item with name: "+item.getName()+" already exists");
    }

}

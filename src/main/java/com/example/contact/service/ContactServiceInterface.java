package com.example.contact.service;

import java.util.List;

import com.example.contact.entity.ContactEntity;

public interface ContactServiceInterface 
{
	public List<ContactEntity> getDetails();
	public ContactEntity getDetailsById(int id);
	public ContactEntity saveItems(ContactEntity  c);
	public ContactEntity update(int id,ContactEntity c1) ;
	public String delete(int id);


}

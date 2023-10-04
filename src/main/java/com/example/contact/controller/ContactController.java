package com.example.contact.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.contact.entity.ContactEntity;
import com.example.contact.service.ContactService;

@RestController

public class ContactController 
{
	@Autowired
	ContactService cs;
	
	@GetMapping
	public String welcome()
	{
		return  "Contact management system";
	}
	
	@GetMapping(value="/getDetails")
	public List<ContactEntity> getList()
	{
		List<ContactEntity> c=new ArrayList<ContactEntity>();
		try
		{
			c=cs.getDetails();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return c;
	}
	
	@GetMapping(value="/getbyId/{id}")
	public ContactEntity getById(@PathVariable int id)
	{
		ContactEntity c=new ContactEntity();
		try
		{
		   c=cs.getDetailsById(id)	;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	@PostMapping(value="/insert")
	public String insert(@RequestBody  ContactEntity c)
	{
		try
		{
		   cs.saveItems(c)	;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data inserted successfully";
	}
	
	@PutMapping(value="/update/{id}")
	public ContactEntity update(@PathVariable int id,@RequestBody ContactEntity ce)
	{
		ContactEntity c=new ContactEntity();
		try
		{
			c=cs.update(id,ce);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable int id)
	{
		try
		{
			cs.delete(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data deleted successfully !";
	}

	
	
	

}

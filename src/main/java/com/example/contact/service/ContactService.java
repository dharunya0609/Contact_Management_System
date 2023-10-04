package com.example.contact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contact.entity.ContactEntity;
import com.example.contact.repository.ContactRepository;


@Service
public class ContactService implements ContactServiceInterface
{
	@Autowired
	ContactRepository repo;
	public List<ContactEntity> getDetails()
	{
		List<ContactEntity> c=new ArrayList<ContactEntity>();
		try
		{
			c=repo.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return c;
	}
	
	public ContactEntity getDetailsById(int id)
	{
		ContactEntity cnew=new ContactEntity();
		
		
		if(id>0)
		{
			try
			{
				cnew=repo.findById(id).get();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return cnew;
		
	}
	
	public ContactEntity saveItems(ContactEntity  c)
	{
		ContactEntity  cnew=new ContactEntity ();
		try
		{
			cnew=repo.save(c);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cnew;
	}
	
	public ContactEntity update(int id,ContactEntity c1) 
	{
		ContactEntity c2 = new ContactEntity();
		try {
			if(id >0) {
				c2 = repo.findById(id).get();
				if(c2 != null) {
					c2.setAddress(c1.getAddress());
					c2.setEmail(c1.getEmail());
					c2.setFname(c1.getFname());
					c2.setLname(c1.getLname());
					repo.save(c2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c2;
	}
	
	public String delete(int id)
	{
		try
		{
			if(id>0 )
			  repo.deleteById(id);
			else
				return "Invalid ID passed";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data deleted successfuly";
	}
	
	
	
	

}

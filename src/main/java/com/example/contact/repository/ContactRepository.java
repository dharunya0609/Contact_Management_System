package com.example.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contact.entity.ContactEntity;


public interface ContactRepository extends JpaRepository<ContactEntity, Integer>
{


}

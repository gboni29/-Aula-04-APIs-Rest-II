package br.ifsp.contacts.repository;

import br.ifsp.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
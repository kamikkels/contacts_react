package contactassigment.contactlistapp.domain;

import java.util.List;

public interface ContactRepositoryCustom
{
  List<Contact> searchByNamesFetchOrganisation(String contactFirstName, String contactLastName, String organisationName);
}

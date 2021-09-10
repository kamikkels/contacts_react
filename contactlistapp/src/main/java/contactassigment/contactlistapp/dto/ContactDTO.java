package contactassigment.contactlistapp.dto;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import contactassigment.contactlistapp.domain.Contact;
import contactassigment.contactlistapp.domain.Organisation;

public class ContactDTO
{

  public static ContactDTO createBy(Contact contact)
  {
    return new ContactDTO(contact);
  }

  public static List<ContactDTO> createListBy(List<Contact> contacts)
  {
    List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>(contacts.size());
    for (Contact c : contacts)
    {
      contactDTOs.add(ContactDTO.createBy(c));
    }
    return contactDTOs;
  }

  private Integer id;

  private String firstName;
  private String lastName;
  private LocalDateTime createdOn;

  private OrganisationDTO organisation;

  public ContactDTO()
  {
  }

  public ContactDTO(Contact contact)
  {
    setId(contact.getId());
    setFirstName(contact.getFirstName());
    setLastName(contact.getLastName());
    setCreatedOn(contact.getCreatedOn());
    Organisation org = contact.getOrganisation();
    if (org != null)
    {
      setOrganisation(new OrganisationDTO(contact.getOrganisation()));
    }
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public void setFirstName(String name)
  {
    this.firstName = name;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setLastName(String name)
  {
    this.lastName = name;
  }

  public String getLastName()
  {
    return lastName;
  }

  public LocalDateTime getCreatedOn()
  {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn)
  {
    this.createdOn = createdOn;
  }

  public OrganisationDTO getOrganisation()
  {
    return organisation;
  }

  public String getCreatedOnDMY()
  {
    return createdOn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public String getCreatedOnDMYHMS()
  {
    return createdOn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
  }

  public String getDisplayName()
  {
    return String.format("%s %s", getFirstName(), getLastName() );
  }

  public void setOrganisation(OrganisationDTO organisation)
  {
    this.organisation = organisation;
  }

  public String getOrganisationInfo()
  {
    OrganisationDTO org = getOrganisation();
    if (org != null)
    {
      return org.getDisplayInfo();
    }
    else
    {
      return Constants.EMPTY_STRING;
    }
  }

  public String getOrganisationName()
  {
    OrganisationDTO org = getOrganisation();
    if (org != null)
    {
      return org.getName();
    }
    else
    {
      return Constants.EMPTY_STRING;
    }
  }

  public String getOrganisationAbn()
  {
    OrganisationDTO org = getOrganisation();
    if (org != null)
    {
      return org.getAbnString();
    }
    else
    {
      return Constants.EMPTY_STRING;
    }
  }
}

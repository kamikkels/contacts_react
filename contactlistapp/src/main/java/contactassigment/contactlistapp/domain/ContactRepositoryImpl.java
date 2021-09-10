package contactassigment.contactlistapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class ContactRepositoryImpl implements ContactRepositoryCustom
{
  Logger logger = LoggerFactory.getLogger(ContactRepositoryImpl.class);

  @PersistenceContext
  EntityManager em;

  @Override
  public List<Contact> searchByNamesFetchOrganisation(String contactFirstName, String contactLastName, String organisationName)
  {
    logger.debug("Query HQL");

    StringBuilder sbuilder = new StringBuilder("SELECT c FROM Contact c LEFT JOIN FETCH c.organisation o ");

    List<String> conditions = new ArrayList<>();

    if (StringUtils.hasText(contactFirstName))
    {
      contactFirstName = contactFirstName.replaceAll("\\*", "%");
      conditions.add("lower(c.firstName) like lower(concat(:firstNamePattern, '%'))");
    }

    if (StringUtils.hasText(contactLastName))
    {
      contactLastName = contactLastName.replaceAll("\\*", "%");
      conditions.add("lower(c.lastName) like lower(concat(:lastNamePattern, '%'))");
    }
    
    if (StringUtils.hasText(organisationName))
    {
      organisationName = organisationName.replaceAll("\\*", "%");
      conditions.add("lower(o.name) like lower(concat(:organisationNamePattern, '%'))");
    }

    if (conditions.size() > 0) 
    {
      sbuilder.append(" WHERE ");
      sbuilder.append(String.join(" AND ", conditions));
    }

    String queryHQL = sbuilder.toString().trim();
    logger.debug("Query HQL: " + queryHQL);
    javax.persistence.Query q = em.createQuery(queryHQL);

    if (StringUtils.hasText(contactFirstName))
    {
      q.setParameter("firstNamePattern", contactFirstName);
    }

    if (StringUtils.hasText(contactLastName))
    {
      q.setParameter("lastNamePattern", contactLastName);
    }

    if (StringUtils.hasText(organisationName))
    {
      q.setParameter("organisationNamePattern", organisationName);
    }

    return q.getResultList();
  }

}

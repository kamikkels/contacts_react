package contactassigment.contactlistapp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contact
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Access(AccessType.PROPERTY)
  private Integer id;

  @Basic(optional = false)
  @Column(nullable = false, length = 30)
  private String firstName;

  @Basic(optional = false)
  @Column(nullable = false, length = 30)
  private String lastName;

  @Basic(optional = false)
  @Column(nullable = false)
  private LocalDateTime createdOn;

  @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.MERGE)
  private Organisation organisation;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String name)
  {
    this.firstName = name;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String name)
  {
    this.lastName = name;
  }

  public LocalDateTime getCreatedOn()
  {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn)
  {
    this.createdOn = createdOn;
  }

  public Organisation getOrganisation()
  {
    return organisation;
  }

  public void setOrganisation(Organisation organisation)
  {
    this.organisation = organisation;
  }
}

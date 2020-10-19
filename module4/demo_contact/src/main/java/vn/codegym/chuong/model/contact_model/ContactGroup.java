package vn.codegym.chuong.model.contact_model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContactGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;

    @OneToMany(mappedBy = "contactGroup", cascade = CascadeType.ALL)
    List<Contact> contactList;

    public ContactGroup() {
    }

    public ContactGroup(String groupName) {
        this.groupName = groupName;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

package add_contact.demoaddcontact.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import add_contact.demoaddcontact.Model.AddContacts;
import add_contact.demoaddcontact.Repository.AddContactRepository;



@Service
public class AddContactService {
    @Autowired
    private AddContactRepository addContactRepository;

    public AddContacts saveData(AddContacts addContacts) {
        return addContactRepository.save(addContacts);
    }

    public AddContacts updateContacts (String id,AddContacts addContacts){
        AddContacts oldContact=addContactRepository.findById(id).orElseThrow(()->new RuntimeException("There is no contact with id: "+id));
        oldContact.setName(addContacts.getName());
        oldContact.setAdress1(addContacts.getAdress1());
        oldContact.setAdress2(addContacts.getAdress2());
        oldContact.setMobile(addContacts.getMobile());
        oldContact.setDistrict(addContacts.getDistrict());
        oldContact.setPincode(addContacts.getPincode());
        oldContact.setEmail(addContacts.getEmail());
        return addContactRepository.save(addContacts);
    }
    public AddContacts getContact(String name){
        return addContactRepository.findByName(name);
    }
    
}

package add_contact.demoaddcontact.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import add_contact.demoaddcontact.Model.AddContacts;
@Repository
public interface AddContactRepository extends MongoRepository<AddContacts,String> {
    public AddContacts findByName(String name);
    
}

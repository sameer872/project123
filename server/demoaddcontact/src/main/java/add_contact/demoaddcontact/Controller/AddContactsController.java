package add_contact.demoaddcontact.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import add_contact.demoaddcontact.Model.AddContacts;
import add_contact.demoaddcontact.Service.AddContactService;
import add_contact.dto.NameDto;


@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class AddContactsController {
    @Autowired
    private AddContactService addContactService;

    @PostMapping("/save")
    public ResponseEntity<AddContacts> saveData(@RequestBody AddContacts addContacts) {
        AddContacts addContacts2 = addContactService.saveData(addContacts);
        return ResponseEntity.ok(addContacts2);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<AddContacts> updateData(@PathVariable String id, @RequestBody AddContacts addContacts){
        return ResponseEntity.ok(addContactService.updateContacts(id, addContacts));
    }
    @GetMapping("/search")
    public ResponseEntity<AddContacts> getContact(@RequestBody NameDto nameDto){
     return ResponseEntity.ok(addContactService.getContact(nameDto.getName()));
    }

    
}

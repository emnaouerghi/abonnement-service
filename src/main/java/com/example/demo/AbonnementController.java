package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AbonnementController {
	@Autowired
	AbonnementService abonService;

	@Autowired
	UserService userService;

	@Autowired
	ActivityService activityService;

	@Autowired
	private MailService mailService;

	@GetMapping("/abonnements")
	List<Abonnement> allAbonnements() {		
		return abonService.getAllAbonnements();
	}

	@DeleteMapping("/abonnements/{id}")
	void deleteUser(@PathVariable Long id) {
		abonService.deleteAbonnementById(id);
	}

	@PostMapping("/add-abonnement/{id}/{idAct}")
	Abonnement newAbonnement(@RequestBody Abonnement abon, @PathVariable Long id, @PathVariable Long idAct) {
		User user = userService.findUserById(id);
		Activity act = activityService.findActivityById(idAct);
		abon.setIdActivity(idAct);
		abon.setIdUser(id);
		abon.setActivity(act);
		abon.setUser(user);
		return abonService.saveAbonnement(abon);
	}

	@PutMapping("/abonnements/{id}")
	public Abonnement updateAbonnement(@PathVariable(value = "id") Long abonId, @RequestBody Abonnement abonDetails) {
		Abonnement abon = abonService.getAbonnement(abonId);
		if (abonDetails.getDateD() != null)
			abon.setDateD(abonDetails.getDateD());

		if (abonDetails.getDateF() != null)
			abon.setDateF(abonDetails.getDateF());

		final Abonnement updatedAbon = abonService.saveAbonnement(abon);
		return abonService.updateAbonnement(updatedAbon);
		
	}

	@ResponseBody
	@GetMapping("/abonnements/sendMail/{idA}")
	public String sendMail(@PathVariable Long idA) {
		Abonnement abon = abonService.getAbonnement(idA);
		Long id = abon.getIdUser();
		User user = userService.findUserById(id);
        abon.setUser(user);

		String body = "Hello \n Congratulations on being part of the team! The whole Club'na welcomes you, and we look forward to a successful journey with you! Welcome aboard!!";

		mailService.send(abon.getUser().getEmail(), "Confirmation Abonnement Club'na ", body);
		return "Mail sent successfuly";

	}

}

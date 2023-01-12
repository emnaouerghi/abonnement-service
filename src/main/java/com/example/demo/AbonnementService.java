package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class AbonnementService  {
	
	@Autowired
	AbonnementRepository abonRepository;
    @Autowired
	ActivityService activityService;
	@Autowired
	UserService userService;
	
	public Abonnement saveAbonnement(Abonnement u) {
		return abonRepository.save(u);
			}

	
	public Abonnement updateAbonnement(Abonnement u) {
		return abonRepository.save(u);
		}

	
	public void deleteAbonnement(Abonnement u) {
		abonRepository.delete(u);
		
	}

	
	public void deleteAbonnementById(Long id) {
		abonRepository.deleteById(id);
		
	}


	
	public List<Abonnement> getAllAbonnements() {
		List<Abonnement> listAbb=(List<Abonnement>) abonRepository.findAll();
		for (Abonnement a : listAbb) {
			Activity act=activityService.findActivityById(a.getIdActivity());
			User user=userService.findUserById(a.getIdUser());
			a.setActivity(act);
			a.setUser(user);
		}
		return listAbb;
	}


	public Abonnement getAbonnement(Long id) {
		/*Optional<Abonnement> a = abonRepository.findById(id);
		Activity act=activityService.findActivityById(a.get().getIdActivity());
		User user=userService.findUserById(a.get().getIdUser());
		a.get().setActivity(act);
		a.get().setUser(user);*/
		Abonnement abon = new Abonnement();
		List<Abonnement> list = getAllAbonnements();
		for (Abonnement a:list) {
			if(a.getId()==id)
			{  User user=userService.findUserById(a.getIdUser());
				a.setUser(user);
				abon=a;}
		}
		System.out.println(abon);
		return abon;
	}

}

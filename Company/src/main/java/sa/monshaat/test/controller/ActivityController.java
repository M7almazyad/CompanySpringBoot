package sa.monshaat.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sa.monshaat.test.model.Activity;
import sa.monshaat.test.services.ActivityServices;

@RestController
public class ActivityController {

	@Autowired
	private ActivityServices activityServices;
	
	@RequestMapping(method=RequestMethod.GET,value="/activity/{id}")
	public void getActivity(@PathVariable int id) {
		activityServices.getActivity(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/activity")
	public void addActivity(@RequestBody Activity activity) {
		activityServices.addActivity(activity);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/activity")
	public void ubdateActivity(@RequestBody Activity activity) {
		activityServices.updateActivity(activity);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/activity/{id}")
	public void deleteActivity(@PathVariable int id) {
		activityServices.deleteActivity(id);
	}
	
	
}

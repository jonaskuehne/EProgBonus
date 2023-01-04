import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

/*
Author: J. Kuehne
Date: 14.12.2022
Lecture: EProg
Project: Exercise 12
Summary:
    This file implements a construction company.
*/

public class CCompany {
	// class attributes
	private Set<CSite> sites;
	private Set<Resource> resources;
	
	// ctor
	public CCompany() {
		// init sets, linked since order important
		sites = new LinkedHashSet<>();
		resources = new LinkedHashSet<>();
	}
	
	// returns all resources of the company
	public Set<Resource> resources() {
		return resources;
	}
	
	// adds resource to company
	public void add(Resource resource) {
		resources.add(resource);
	}
	
	// distributes resources
	public void nextDay() {
		// check dynamic boys
		for (CSite site : sites) {
			// is dynamic?
			if (site instanceof DynamicConstructionSite) {
				// add stuff
				resources.addAll(((DynamicConstructionSite)site).getOverflow());
			}
		}
		
		// go through resources with iterator since we remove some
		Iterator<Resource> itr = resources.iterator();
		// go through resources
		while (itr.hasNext()) {
			// get current resource
			Resource current = itr.next();
			// go through possible sites
			for (CSite site : sites) {
				// can be added
				if (site.canAdd(current)) {
					// add
					site.add(current);
					// remove from resources
					itr.remove();
					// is added, so break
					break;
				}
			}
		}
	}
	
	// ehre
	public CSite createCSite(int type) {
		// Aendern Sie diese Methode, falls Sie Task (a) nicht geloest haben.
		return createCSite(Set.of(type), 2);
	}
	
	// creates and returns site with types and limit
	public CSite createCSite(Set<Integer> types, int limit) {
		// new site
		CSite newSite = new ConstructionSite(types, limit, sites);
		// add to set
		sites.add(newSite);
		// return site
		return newSite;
	}
	
	// creates and returns dynamic site
	public CSite createCSite(Set<Integer> types, int limit, int flowLimit) {
		// new site
		CSite newSite = new DynamicConstructionSite(types, limit, flowLimit, sites);
		// add to set
		sites.add(newSite);
		// return site
		return newSite;
	}
}




import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/*
Author: J. Kuehne
Date: 14.12.2022
Lecture: EProg
Project: Exercise 12
Summary:
    This file implements a construction site.
*/

public class ConstructionSite implements CSite {
	// class variables
	protected Map<Integer, Integer> stock;
	protected Set<Resource> resources;
	protected int limit;
	protected Set<CSite> siteSet;
	
	// ctors
	public ConstructionSite(Set<Integer> types, int limit, Set<CSite> siteSet) {
		// set stuff
		this.limit = limit;
		// stock
		stock = new HashMap<>();
		// currently nothing there -> zero for each type
		for (int type : types) {
			stock.put(type, 0);
		}
		// set of resources
		resources = new HashSet<>();
		// list of sites, used to remove itself
		this.siteSet = siteSet;
	}
	
	@Override
	// returns all resources of the site
	public Set<Resource> resources() {
		return resources;
	}

	@Override
	// checks if a resource can be added
	public boolean canAdd(Resource resource) {
		// can be added
		return stock.containsKey(resource.type()) &&  stock.get(resource.type()) < limit;
	}

	@Override
	// adds resource, exception if not possible
	public void add(Resource resource) {
		// not possible
		if (!canAdd(resource)) {
			throw new IllegalArgumentException();
		}
		// add
		resources.add(resource);
		// adjust stock, increase by one
		stock.replace(resource.type(), stock.get(resource.type()) + 1);
		
	}

	@Override
	// uses resource, exception if not owned
	public void use(Resource resource) {
		// resource not owned by site
		if (!resources.contains(resource)) {
			throw new IllegalArgumentException();
		}
		// remove
		resources.remove(resource);
		// adjust stock, decrease by one
		stock.replace(resource.type(), stock.get(resource.type()) - 1);
	}

	@Override
	// removes itself from set
	public void close() {
		siteSet.remove(this);
	}

}

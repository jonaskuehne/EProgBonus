import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/*
Author: J. Kuehne
Date: 14.12.2022
Lecture: EProg
Project: Exercise 12
Summary:
    This file implements a dynamic construction site.
*/

public class DynamicConstructionSite extends ConstructionSite {
	// class variables
	protected int flowLimit;
	
	// ctor
	public DynamicConstructionSite(Set<Integer> types, int limit, int flowLimit, Set<CSite> siteSet) {
		super(types, limit, siteSet);
		this.flowLimit = flowLimit;
	}
	
	// additional method, returns set of overflow resources and removes them here
	public Set<Resource> getOverflow() {
		Set<Resource> overflow = new HashSet<>();
		// go through resources, use iterator since we remove stuff
		Iterator<Resource> itr = resources.iterator();
		// go through
		while (itr.hasNext()) {
			// get next
			Resource current = itr.next();
			// overflow of type?
			if (stock.get(current.type()) > flowLimit) {
				// add to set
				overflow.add(current);
				// adjust stock, decrease by one
				stock.replace(current.type(), stock.get(current.type()) - 1);
				// remove here
				itr.remove();
			}
		}
		// result
		return overflow;
	}

}

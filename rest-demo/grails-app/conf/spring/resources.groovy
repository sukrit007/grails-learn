import com.meltmedia.Account;
import com.meltmedia.Customer;
import com.meltmedia.Person

import com.meltmedia.representations.RootRepresentation
import grails.rest.render.errors.VndErrorJsonRenderer;
import grails.rest.render.hal.HalJsonCollectionRenderer;
import grails.rest.render.hal.HalJsonRenderer;

// Place your Spring DSL code here
beans = {
	vndJsonErrorRenderer(VndErrorJsonRenderer)
	
	halRootRenderer(HalJsonRenderer, RootRepresentation)
	
	halPersonsRenderer(HalJsonCollectionRenderer, Person)
	halPersonRenderer(HalJsonRenderer, Person)
	
	halCustomersRenderer(HalJsonCollectionRenderer, Customer)
	halCustomerRenderer(HalJsonRenderer, Customer)
	
	halAccountsRenderer(HalJsonCollectionRenderer, Account)
	halAccountRenderer(HalJsonRenderer, Account)


}

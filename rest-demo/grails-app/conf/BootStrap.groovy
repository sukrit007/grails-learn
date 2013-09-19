import org.apache.commons.logging.LogFactory

import com.meltmedia.Account
import com.meltmedia.Customer
import com.meltmedia.Person


class BootStrap {

	private static final def log = LogFactory.getLog(this)

	def init = { servletContext ->
		new Person(firstName:'Sukrit', lastName:'Khera',  emailAddress: 'sukrit007@gmail.com').save()
	
		new Customer(name: 'Sukrit', accounts: [new Account(balance: 400.0d), new Account(balance:500.0d)]).save()
		new Customer(name: 'Stewie', accounts: [Account.get(1)]).save()
		
	}
	def destroy = {
	}
}

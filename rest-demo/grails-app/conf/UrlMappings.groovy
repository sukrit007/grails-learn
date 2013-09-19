class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")

        "500"(view:'/error')
		"/api"(resources:"root")
			"/api/persons"(resources:"person")
			"/api/customers"(resources:"customer") {
				"/accounts" (resources:"customerAccount")
			}
			"/api/accounts"(resources:"account")
		
	}
}

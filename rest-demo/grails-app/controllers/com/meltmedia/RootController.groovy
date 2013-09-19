package com.meltmedia

import com.meltmedia.representations.RootRepresentation;

class RootController {
	
	static responseFormats = ['hal']

    def index() {
		def rootRepresentation = new RootRepresentation(
			description: "Meltmedia REST API Demo"	
		)
		rootRepresentation.with {
			link rel:'persons', href: g.createLink(resource:'person', absolute:true)
			link rel:'customers', href: g.createLink(resource:'customer', absolute:true)
			link rel:'accounts', href: g.createLink(resource:'account', absolute:true)
		}
		respond rootRepresentation
	}
}

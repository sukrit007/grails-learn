package com.meltmedia

import grails.rest.Resource;

@Resource(uri='/api/persons', formats=['hal', 'json'])
class Person {

	String firstName
	String middleName
	String lastName
	String emailAddress

	static constraints = {
		firstName size:1..100
		middleName size:1..100, nullable:true
		lastName size:1..100
		emailAddress size:1..255, email:true
	}
}

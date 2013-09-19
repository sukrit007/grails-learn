package com.meltmedia

import grails.rest.Linkable;
import grails.rest.Resource;

@Linkable
class Customer {
	
	String name
	
	static hasMany = [accounts:Account]
	
    static constraints = {
		name size:1..100
    }
	
}

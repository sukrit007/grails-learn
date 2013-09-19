package com.meltmedia

import grails.rest.Resource;

@Resource(formats = ['hal', 'json'])
class Account {
	
	double balance
	
	static hasMany = [customers: Customer]
	static belongsTo = [Customer]

    static constraints = {
		balance min:0.0d
    }
}

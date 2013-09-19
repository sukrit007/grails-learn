package com.meltmedia

import java.io.Serializable;

import org.codehaus.groovy.grails.web.taglib.NamespacedTagDispatcher;

import grails.rest.RestfulController;

class CustomerController extends RestfulController {
	static responseFormats = ['hal', 'json']

    CustomerController() {
		super(Customer)
	}
	
	
	def show(Customer customer) {
        customer?.with {
            link(rel:'accounts', href:g.createLink(
                    resource: 'customerAccount', params:[customerId:id], absolute: true))
        }
		respond customer
	}

    def delete(Customer customer) {
        if(customer) {
            customer.delete()
            render status: 204
        }
        else {
            render status: 404
        }
    }
	
	
}

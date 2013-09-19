package com.meltmedia


import grails.transaction.Transactional

@Transactional
class CustomerAccountController {
    static responseFormats = ['hal', 'json']


    def update(Account account) {
        def customer = Customer.get params.customerId
        if (!account || !customer) {
            return render(status:404)
        }
        customer.addToAccounts account
        customer.save flush:true
        respond  linkAccount(account)
    }

    def index() {
        def accounts =  Account.createCriteria().list {
            customers {
                eq 'id', params.customerId.toLong()
            }
        }
        respond accounts.collect({
            linkAccount it})
    }

    def show(Account account) {
        def customer = Customer.get params.customerId
        if (account && customer && customer.accounts.contains(account)) {
            respond account
        }
        else {
            render status: 404
        }

    }

    def delete(Account account) {
        def customer = Customer.get params.customerId
        if( account && customer && customer.accounts.contains(account) ) {
            customer.removeFromAccounts account
            customer.save flush:true
            render status: 204
        }
        else {
            render status: 404
        }

    }

    def linkAccount(Account account) {
        account.customers = null
        account.link rel:'customerAccount', href: g.createLink(
                controller: 'customerAccount',id:account.id,
                action: 'show',
                params:[customerId:params.customerId], absolute: true)
        account
    }





}

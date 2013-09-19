package com.meltmedia


import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.*

@Transactional
class CustomerAccountController {
    static responseFormats = ['hal', 'json']


    def update(Account account) {
        def customer = Customer.get params.customerId
        if (!account || !customer) {
            render(status:NOT_FOUND)
        }
        else {
            customer.addToAccounts account
            customer.save flush:true
            respond  linkAccount(account)
        }
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

    def show() {
        respond findAccount()
    }



    def delete() {
        def customer = Customer.get params.customerId
        def account = findAccount()
        if( account && customer) {
            customer.removeFromAccounts account
            customer.save flush:true
            render status: NO_CONTENT
        }
        else {
            render status: NOT_FOUND
        }

    }


    private def Account findAccount() {
        Account.createCriteria().get {
            and {
                customers {
                    eq 'id', params.customerId.toLong()
                }
                eq 'id', params.id.toLong()
            }
        }
    }

    private def linkAccount(Account account) {
        account.customers = null
        account.link rel:'customerAccount', href: g.createLink(
                resource: 'customerAccount',id:account.id,
                action: 'show',
                params:[customerId:params.customerId], absolute: true)
        account
    }





}

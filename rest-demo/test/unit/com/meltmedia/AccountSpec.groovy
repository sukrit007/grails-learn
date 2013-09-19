package com.meltmedia

import grails.rest.render.RenderContext
import grails.rest.render.hal.HalJsonCollectionRenderer
import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.web.mime.MimeType
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Account)
class AccountSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given: "Something"
        when : "something"

        then: "something"
        def renderer = new HalJsonCollectionRenderer(Account, MimeType.HAL_JSON)
        def mockRenderContext = [
            getAcceptMimeType: {MimeType.HAL_JSON},
            getWriter: {new OutputStreamWriter(System.out)}
        ] as RenderContext
        //renderer.renderInternal(new Account(balance: 1.0d), mockRenderContext)
        //assert false

    }
}

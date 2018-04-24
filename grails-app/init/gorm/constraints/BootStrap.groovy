package gorm.constraints

import org.grails.datastore.gorm.validation.constraints.registry.ConstraintRegistry

import example.BarConstraint
import example.Foo

class BootStrap {

    ConstraintRegistry gormValidatorRegistry

    def init = { servletContext ->

        gormValidatorRegistry.addConstraint(BarConstraint)


        Foo.withNewSession {
            Foo.withNewTransaction {
                Foo foo1 = Foo.findByProp('prop1')

                if (foo1) {
                    foo1.delete(flush: true, failOnError: true)
                }

                foo1 = new Foo(prop: 'prop1')
                foo1.save(flush: true, failOnError: true)

                Foo foo2 = Foo.findByProp('Prop2')

                if (foo2) {
                    foo2.delete(flush: true, failOnError: true)
                }

                foo2 = new Foo(prop: 'Prop2')
                foo2.save(flush: true, failOnError: true)  // this line should fail
            }
        }
    }
    def destroy = {
    }
}
